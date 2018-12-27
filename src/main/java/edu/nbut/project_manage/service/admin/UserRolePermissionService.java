package edu.nbut.project_manage.service.admin;

import edu.nbut.project_manage.bean.entity.*;
import net.sf.json.JSONObject;

import java.util.List;


public interface UserRolePermissionService {
    //####################用户角色管理

    /**
     * 获取所有用户的信息
     *
     * @param page page 开始页
     * @param size size 每页大小
     * @param draw draw ???
     * @return result JSONObject 用户信息
     */
    JSONObject getAllUser(Integer page, Integer size, Integer draw);

    /**
     * 查看所有角色
     *
     * @param UserId
     * @return 角色信息
     */
    List getUserRole(Integer UserId);

    /**
     * 添加用户
     * @param realName 用户姓名
     * @param unitId   所属单位Id
     * @param username 登录名
     * @param password 密码
     * @param position 岗位
     * @param roles    用户所拥有的角色ID
     * @param remarks  说明
     * @return 成功 1 ; 失败 0
     */
    int insertUser(String realName, String unitId, String username,
                   String password, String position, char[] roles,
                   String remarks);

    /**
     * 为用户添加角色
     *
     * @param userRole
     * @return 成功1 ; 失败0
     */
    int addUserRole(UserRole userRole);

    /**
     * 为用户删除角色
     *
     * @param userRole
     * @return 成功1 ; 失败0
     */
    int deleteUserRole(UserRole userRole);

    /**
     * 修改用户信息（包括用户的所属单位名字）
     *
     * @param userInfo
     * @param unitTitle
     * @return 成功 1; 失败 0
     */
    int updateUserInfoAndUnitTitle(UserInfo userInfo, String unitTitle);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteUserByUserId(Integer userId);

    /**
     * 获取所有单位的信息
     *
     * @return
     */
    List<Unit> selectAllUnit();


//#####################角色权限管理

    /**
     * 获取所有角色
     *
     * @return
     */
    List<Role> getAllRole();

    /**
     * 根据参数：外层导航ID(parentId）和角色ID(roleId),返回该角色拥有的权限
     *
     * @param parentId:left页面的外层导航栏
     * @param roleId:角色ID
     * @return 角色ID对应的权限集合（按外层导航ID分组）
     */
    List<RolePermission> getRolePermission(Integer parentId, Integer roleId);

    /**
     * 修改角色的权限
     *
     * @param roleId   角色ID
     * @param parentId 权限的父ID
     * @param checked  已选中的权限
     * @return
     */
    Integer updateRoleFunction(String roleId, String parentId, String checked);


}
