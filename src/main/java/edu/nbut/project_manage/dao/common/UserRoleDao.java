package edu.nbut.project_manage.dao.common;

import edu.nbut.project_manage.bean.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleDao {
    /**
     * 查询所有角色
     *
     * @param userId user id
     * @return result
     */
    List<UserRole> getUserRole(Integer userId);

    /**
     * 在添加用户时，通过用户Id，批量为用户添加角色
     * @param userId 用户Id
     * @param roleId 用户所拥有的角色ID
     * @return
     */
    int addUserRoleByUserId(@Param("userId") Integer userId , @Param("roleId") char roleId);
    /**
     * 为用户添加角色
     * @param userRole
     * @return
     */
    int addUserRole(UserRole userRole);
    /**
     * 为用户删除角色
     * @param userRole
     * @return 成功1 ; 失败0
     */
    int deleteUserRole(UserRole userRole);
}
