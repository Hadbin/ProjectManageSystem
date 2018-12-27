package edu.nbut.project_manage.service.common;

import edu.nbut.project_manage.bean.dto.ResultDTO;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.UserInfo;

import java.util.List;

public interface UserService {
/*
    ResultDTO login(String username, String password);*/
    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @return
     */
    UserInfo login(String username, String password);

    /**
     * 获取用户的所有角色
     * @param userId 用户ID
     * @return 用户角色的集合
     */
    List<Role> getUserAllPermission(Integer userId);


}
