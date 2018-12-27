package edu.nbut.project_manage.dao.common;

import edu.nbut.project_manage.bean.entity.Permission;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface UserDao {
    /**
     * 根据id查询用户
     *
     * @param id user id
     * @return 查询结果
     */
    UserInfo findById(Integer id);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    UserInfo judgeUsername(String username);

    /**
     * 根据用户名查询用户Id
     * @param username
     * @return
     */
    Integer findUserIdByUsername(String username);

/*    *//**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 查询结果
     *//*
   UserInfo findByUsername(String username);*/
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    UserInfo login(@Param("username") String username, @Param("password") String password);

    /**
     * 查找所有用户
     * @return
     */
    List<UserInfo> findAllUser();

    /**
     * 添加用户
     * @param realName 用户姓名
     * @param unitId   所属单位Id
     * @param username 登录名
     * @param password 密码
     * @param position 岗位
     * @param RegDate  用户注册时间
     * @param remarks  说明
     * @return 成功 1 ; 失败 0
     */
    int insertUser(@Param("realName") String realName,@Param("unitId") String unitId,@Param("username") String username,
                   @Param("password")  String password, @Param("position")String position,@Param("regDate") String RegDate,
                   @Param("remarks") String remarks);

    /**
     * 判断操作员类别
     * @param UserId 操作员ID
     * @return 返回操作员类别编号
     */
    /*ArrayList<Integer> judgeType(Integer UserId);*/

    /**
     * 获取用户的角色
     * @param UserId 操作员ID
     * @return 用户拥有的角色集合
     */
    List<Role> getUserRole(Integer UserId);
    /**
     * 获取角色的权限
     * @param RoleId 角色ID
     * @return 角色拥有的权限集合
     */
    List<Permission> getRolePermission(Integer RoleId);

    /**
     * 修改用户信息
     * @param userInfo
     * @return 成功1 ; 失败0
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUserByUserId(Integer userId);
}
