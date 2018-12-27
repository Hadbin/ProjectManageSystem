package edu.nbut.project_manage.web.admin;

import edu.nbut.project_manage.bean.entity.*;
import edu.nbut.project_manage.service.admin.UserRolePermissionService;
import edu.nbut.project_manage.utils.DateListToJson;
import edu.nbut.project_manage.web.BaseController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class UserRolePermissionController extends BaseController {
    @Autowired
    private UserRolePermissionService userRolePermissionService;

    //################用户角色管理
    @RequestMapping("/userRole")
    public String userRole() {
        System.out.println("页面跳转至admin/userrole");
        return "admin/userrole";
    }

    @GetMapping("/getAllUser")
    @ResponseBody
    public JSONObject getAllUser(@RequestParam(value = "start", required = false) String start,
                                 @RequestParam(value = "length", required = false) String length,
                                 @RequestParam(value = "draw", required = false) String draw_
    ) {
        //System.out.println("查询结果:"+userRolePermissionService.listUser(page, size));
        //int page=1;int size=10;
        //System.out.println("start="+start+"  length="+length+" draw="+draw_);
        int startpage = Integer.parseInt(start);
        int total = Integer.parseInt(length);
        int draw = Integer.parseInt(draw_);
        JSONObject json = userRolePermissionService.getAllUser(startpage, total, draw);
        System.out.println("getAllUserJson=" + json);
        return json;
    }
    @PostMapping("/insertUser")
    @ResponseBody
    public int insertUser(@RequestParam(value = "realName", required = false) String realName,
                          @RequestParam(value = "unitId", required = false) String unitId,
                          @RequestParam(value = "username", required = false) String username,
                          @RequestParam(value = "password", required = false) String password,
                          @RequestParam(value = "position", required = false) String position,
                          @RequestParam(value = "userType", required = false) String userType,
                          @RequestParam(value = "remarks", required = false) String remarks

    ){
        char[] roles=userType.toCharArray();
        return userRolePermissionService.insertUser(realName,  unitId,username,password,position,roles,remarks);
    }
    /**
     *  根据用户ID获取用户角色
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserRoleJson")
    @ResponseBody
    public JSONObject getUserRoleJson(@RequestParam String userId) {
        JSONObject obj = new JSONObject();
        if (userId == null || userId.equals("")) {
            userId = "0";
        }
        List<UserRole> list = userRolePermissionService.getUserRole(Integer.parseInt(userId));

        obj.put("data", DateListToJson.dateToJson(list));
        System.out.println("用户角色信息=" + obj);
        return obj;
    }

    @RequestMapping(value = "addUserRole")
    @ResponseBody
    public int addUserRole(@RequestBody UserRole userRole) {
        System.out.println("添加角色的信息=" + userRole.toString());
        return userRolePermissionService.addUserRole(userRole);
    }

    @RequestMapping(value = "deleteUserRole")
    public @ResponseBody
    int deleteUserRole(@RequestBody UserRole userRole) {
        return userRolePermissionService.deleteUserRole(userRole);
    }

    /**
     * 修改用户信息（包括用户的所属单位名字）
     * @param userId
     * @param realName
     * @param unitTitle
     * @param username
     * @param password
     * @param remarks
     * @return
     */
    @RequestMapping(value = "updateUserInfo")
    @ResponseBody
    public int updateUserInfoAndUnitTitle( /*@RequestBody UserInfo userInfo*/
                              @RequestParam(value = "userId", required = false) Integer userId,
                              @RequestParam(value = "realName", required = false) String realName,
                              @RequestParam(value = "unitName", required = false) String unitTitle,
                              @RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password,
                              @RequestParam(value = "remarks", required = false) String remarks
    ) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setName(realName);
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setRemarks(remarks);
        int i = 0;
        i = userRolePermissionService.updateUserInfoAndUnitTitle(userInfo,unitTitle);
        return i;
    }

    @RequestMapping(value = "deleteUserByUserId")
    @ResponseBody
    public int deleteUserByUserId( @RequestParam(value = "userId", required = false) String userId) {
        System.out.println("userId="+userId);
        if (userId == null || userId.equals("")) {
            userId = "0";
        }
        return userRolePermissionService.deleteUserByUserId(Integer.parseInt(userId));
    }
    /**
     * 获取所有单位
     *
     * @return 单位
     */

    @GetMapping(value = "selectAllUnit")
    @ResponseBody
    public List<Unit> selectAllUnit() {
        List<Unit> units = userRolePermissionService.selectAllUnit();
        System.out.println("单位信息=" + units);
        return units;
        // return null;
    }

    //################角色权限管理
    @RequestMapping("/rolePermission")
    public String rolePermission() {
        System.out.println("页面跳转至admin/rolePermission");
        return "admin/rolePermission";
    }

    /**
     * 获取所有角色
     *
     * @return
     */
    @RequestMapping(value = "getAllRole")
    @ResponseBody
    public JSONObject getAllRoleJson() {
        JSONObject obj = new JSONObject();
        List<Role> list = userRolePermissionService.getAllRole();
        obj.put("data", DateListToJson.dateToJson(list));
        return obj;
    }

    /**
     * 获取某一角色的所有权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "getRolePermission")
    public @ResponseBody
    JSONArray getRolePermission(@RequestParam String roleId) {
        if (roleId == null || roleId.equals("")) {
            roleId = "0";
        }
        System.out.println("roleId=" + roleId);
        List<RolePermission> list = userRolePermissionService.getRolePermission(0, Integer.parseInt(roleId));
        logger.info("##################角色的权限List=" + list);
        JSONArray array = DateListToJson.dateToJson(list);

        return array;
    }

    @RequestMapping(value = "updateRolePermission")
    @ResponseBody
    public int updateRoleFunction(@RequestParam String roleId, @RequestParam String parentId, @RequestParam String checked) {
        int i = 0;
        System.out.println("roleId=" + roleId);
        System.out.println("parentId=" + parentId);
        System.out.println("checked=" + checked);
        if (!((roleId == null) || (roleId.isEmpty()))) {
            if (!((parentId == null) || (parentId.isEmpty()))) {
                i = userRolePermissionService.updateRoleFunction(roleId, parentId, checked);
            }
        }
        return i;
    }
}
