package edu.nbut.project_manage.service.common.Impl;

import edu.nbut.project_manage.bean.dto.ResultDTO;
import edu.nbut.project_manage.bean.entity.Permission;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.UserInfo;
import edu.nbut.project_manage.dao.common.UserDao;
import edu.nbut.project_manage.enums.DataDictionary;
import edu.nbut.project_manage.service.BaseService;
import edu.nbut.project_manage.service.common.UserService;
import edu.nbut.project_manage.utils.JWTUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserDao userDao;
/*
    @Override
    public ResultDTO login(String username, String password) {
        UserInfo user = userDao.login(username, password);
        if (user == null) {
            logger.info("用户名或密码错误");
            return null;
        } else {
            *//*获得角色ID start*//*
            List<Role> roles=userDao.getUserRole(user.getUserId());
            *//*获得角色ID end*//*

            *//*获得权限ID start*//*
            for(Role role:roles){
                role.setPermissions(userDao.getRolePermission(role.getRoleId()));
            }
            *//*获得权限ID end*//*
            *//*JWT start*//*
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("userId", user.getUserId());
            claims.put("username", username);
            String jwt = JWTUtils.createToken(claims);
            *//*JWT end*//*

            *//*判断操作员类别 start*//*
            //ArrayList<Integer> optionerType = userDao.judgeType(user.getUserId());
            ResultDTO resultDTO=new ResultDTO(DataDictionary.LOGIN_SUCCESS)
                    .addData("token", jwt).*//*addData("optionerType", optionerType).*//*addData("UserInfo",user).addData("roles",roles);
            System.out.println("操作员：" + resultDTO.toString());
            *//*判断操作员类别 end*//*
            return resultDTO;
        }
    }*/
    @Override
    public UserInfo login(String username, String password){
        UserInfo userInfo = userDao.login(username, password);
        if (userInfo == null) {
            logger.info("用户名或密码错误");
            return null;
        } else {
            //ResultDTO resultDTO=new ResultDTO().addData("userInfo",userInfo).addData("roles",roles);
            return userInfo;
        }
    }

    @Override
    public List<Role> getUserAllPermission(Integer userId) {
        /*获得角色ID start*/
        List<Role> roles=userDao.getUserRole(userId);
        /*获得角色ID end*/

        /*获得权限ID start*/
        for(Role role:roles){
            role.setPermissions(userDao.getRolePermission(role.getRoleId()));
        }
        /*获得权限ID end*/
        return roles;
    }
}
