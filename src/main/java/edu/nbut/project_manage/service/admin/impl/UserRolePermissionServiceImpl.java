package edu.nbut.project_manage.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.nbut.project_manage.bean.entity.*;
import edu.nbut.project_manage.dao.admin.DicItemDao;
import edu.nbut.project_manage.dao.common.*;
import edu.nbut.project_manage.service.admin.UserRolePermissionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRolePermissionServiceImpl implements UserRolePermissionService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private UnitDao unitDao;
    @Autowired
    private DicItemDao dicItemDao;
    //####################用户角色管理

    /**
     * 分页列出所有用户
     *
     * @param startpage
     * @param total
     * @param draw      draw ???
     * @return
     */
    @Override
    public JSONObject getAllUser(Integer startpage, Integer total, Integer draw) {
        JSONObject json = new JSONObject();
        PageHelper.startPage(startpage / total + 1, total);
        /* 获得所有用户 start*/
        List<UserInfo> listUsers = userDao.findAllUser();
        /* 获得所有用户 end*/

        /* 设置用户的角色(角色名是从字典库获取的）和单位信息 start*/
        for (UserInfo userInfo : listUsers) {
            userInfo.setRoles(userDao.getUserRole(userInfo.getUserId()));
            /**
             * 为了同步操作员类型名字和字典库同步
             * 这里的dicItemDao.getRoleTitle(role.getTitle()) 方法得到数据表Role中title字段的值(int型数据)
             * 在用这个值，去数据表DicItem中获取对应的Title值(varchar型数据)
             */
            for(Role role:userInfo.getRoles()){
                System.out.println("角色名称="+dicItemDao.getRoleTitle(role.getTitle()));
                role.setTitle(dicItemDao.getRoleTitle(role.getTitle()));
            }
            userInfo.setUnit(unitDao.getUnitInfoById(userInfo.getUnitId()));
        }
        /* 获得用户的角色 end*/
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(listUsers);
        JSONArray array = ListToTableJson(listUsers);

        json.put("draw", draw);
        //System.out.println("draw="+draw);
        json.put("recordsTotal", pageInfo.getTotal());
        json.put("recordsFiltered", pageInfo.getTotal());
        json.put("data", array);
        return json;
    }

    @Override
    public int insertUser(String realName, String unitId, String username, String password, String position, char[] roles, String remarks) {
        UserInfo u=userDao.judgeUsername(username);
        if(u!=null){
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regDate=sdf.format(new Date());
        //System.out.println("注册时间="+regDate);
        userDao.insertUser(realName, unitId, username, password, position,regDate, remarks);
        int UserId=userDao.findUserIdByUsername(username);
       // userDao.selectUserId(username);

        for(int i=0;i<roles.length;i++){
            userRoleDao.addUserRoleByUserId(UserId,roles[i]);
        }

        return 1;
    }

    /**
     * 为用户添加角色
     *
     * @param userRole
     * @return 成功1 ; 失败0
     */
    @Override
    public int addUserRole(UserRole userRole) {
        return userRoleDao.addUserRole(userRole);
    }

    /**
     * 为用户删除角色
     *
     * @param userRole
     * @return 成功1 ; 失败0
     */
    @Override
    public int deleteUserRole(UserRole userRole) {
        return userRoleDao.deleteUserRole(userRole);
    }

    /**
     * 修改用户信息（包括用户的所属单位名字）
     *
     * @param userInfo,
     * @param unitTitle,
     * @return 成功 1; 失败 0
     */
    @Override
    public int updateUserInfoAndUnitTitle(UserInfo userInfo, String unitTitle) {
        //  String unitTitle=unitDao.getUnitTitle(userInfo.getUserId());
        //   System.out.println("unitTitle="+unitTitle);
        //  System.out.println("updateUserInfoAndUnitTitle###"+userInfo.getUserId());
        String id = String.valueOf(userInfo.getUserId());
        unitDao.updateUnitTitle(unitTitle, id);
        System.out.println("修改单位信息成功");
        return userDao.updateUserInfo(userInfo);
    }

    /**
     * 获取某一用户的角色信息
     *
     * @param userId
     * @return 角色信息
     */
    @Override
    public List<UserRole> getUserRole(Integer userId) {
        /**
         * 因为 为了同步操作员类型名字和字典库同步，
         * 所以list中角色的title是int数据。
         * 需要用这个数字去字典库DicItem中获取相应的字符串数据
         */
        List<UserRole> userRoles=userRoleDao.getUserRole(userId);
        System.out.println("userRoles="+userRoles);
        for(UserRole userRole:userRoles){
            userRole.setTitle(dicItemDao.getRoleTitle(userRole.getTitle()));
        }
        System.out.println("角色名称="+userRoles);
        return userRoles;
    }

    @Override
    public int deleteUserByUserId(Integer userId) {
        System.out.println("userId=" + userId);
        return userDao.deleteUserByUserId(userId);
    }

    @Override
    public List<Unit> selectAllUnit() {
        return unitDao.selectAllUnit();
    }

//#####################角色权限管理


    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }


    @Override
    public List<RolePermission> getRolePermission(Integer parentId, Integer roleId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("parentId", parentId);
        map.put("roleId", roleId);
      /*  System.out.println("p1="+parentId);
        for ( Integer m: map.values()) {
            System.out.println("parentId="+m);
        }*/
        //System.out.println("map="+map.get(parentId));
        return rolePermissionDao.getRolePermission(map);
    }

    @Override
    public Integer updateRoleFunction(String roleId, String parentId, String checked) {
        int i = 0;
        boolean bChk = false;
        try {
            bChk = Boolean.valueOf(checked);
        } catch (Exception e) {
            bChk = false;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("parentId", Integer.parseInt(parentId));
        map.put("roleId", Integer.parseInt(roleId));
        if (rolePermissionDao.selectCountRolePermission(map) > 0) {
            if (!bChk) {
                //删除
                i = rolePermissionDao.deleteRolePermission(map);
            }
        } else {
            if (bChk) {
                i = rolePermissionDao.insertRolePermission(map);
            }
        }
        return i;
    }

    //#####只在本类中用到的方法

    /**
     * 返回的数据转化成表格的json形式
     *
     * @param list
     * @returnI
     */
    private JSONArray ListToTableJson(List<UserInfo> list) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject json = new JSONObject();
            json.put("Name", list.get(i).getName());
            json.put("UnitTitle", list.get(i).getUnit().getTitle());
            json.put("Username", list.get(i).getUsername());
            json.put("Password", list.get(i).getPassword());
            json.put("UserId", list.get(i).getUserId());
            //System.out.println("ListToTableJson的Roles"+list.get(i).getRoles());
            json.put("Roles", list.get(i).getRoles());
            //json.put("UserTypeName",list.get(i).getTypeName());
            // json.put("Dept",list.get(i).getDept());
            json.put("remarks", list.get(i).getRemarks());
            array.add(json);
        }
        return array;
    }
}
