package edu.nbut.project_manage.filter.utils;

import edu.nbut.project_manage.bean.entity.Permission;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.UserInfo;
import edu.nbut.project_manage.dao.common.RolePermissionDao;
import edu.nbut.project_manage.dao.common.UserDao;
import edu.nbut.project_manage.dao.common.UserRoleDao;
import edu.nbut.project_manage.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ride
 * @date 18-3-14 下午6:54
 * <p>
 * 权限检查类, 判断用户访问的url是否有权限
 */
public class PermissionUtils {

    private static final Logger logger = LoggerFactory.getLogger(PermissionUtils.class);

    private static UserDao userDao;

    private static UserRoleDao userRoleDao;

    private static RolePermissionDao rolePermissionDao;

    static {
        userDao = (UserDao) SpringContextUtils.getContext().getBean("userDao");
        userRoleDao = (UserRoleDao) SpringContextUtils.getContext().getBean("userRoleDao");
        rolePermissionDao = (RolePermissionDao) SpringContextUtils.getContext().getBean("rolePermissionDao");
    }

    /**
     * 判断当前用户是否存在
     *
     * @param userId user id
     * @return true ===> user exists | false ==> user not exists
     */
    public static boolean isUserExists(Integer userId) {
        UserInfo user = userDao.findById(userId);
        return user==null? false:true;
    }

    /**
     * 判断用户是否有该url权限
     *
     * @param userId        用户id
     * @param permissionUrl 权限url
     * @return true
     */
    /*public static boolean judge(Integer userId, String permissionUrl) {
        // 拿到用户当前的所有角色
        List<Role> roles = userRoleDao.findRolesByUserId(userId);
        logger.info("##### roles ====> {} ######", roles);
        for (Role role : roles) {
            List<Permission> permissions = rolePermissionDao.findAllPermissionByRoleId(role.getRoleId());
            if (permissions == null || permissions.size() == 0) {
                // 当前角色未分配权限的情况下, 就可能造成空指针异常情况
                continue;
            }
            for (Permission permission : permissions) {
                if (permissions == null) {
                    continue;
                }
            }
        }

        logger.info("##### 用户权限不足 #####");

        return false;
    }*/
}
