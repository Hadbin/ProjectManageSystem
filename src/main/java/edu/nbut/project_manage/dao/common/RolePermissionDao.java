package edu.nbut.project_manage.dao.common;

import edu.nbut.project_manage.bean.entity.Permission;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RolePermissionDao {

    /**
     * 查询该角色的所有权限
     *
     * @param roleId 用户权限
     * @return 权限集合
     */
    List<Permission> findAllPermissionByRoleId(Integer roleId);

    /**
     * 查询该角色拥有的权限
     * @param map key1:角色ID ;  key2:权限的父类ID(parentId)
     * @return 权限集合
     */
    List<RolePermission> getRolePermission(Map<String,Integer> map);

    /**
     * 查询该角色拥有权限的数量
     * @param map key1:角色ID ;  key2:权限的父类ID(parentId)
     * @return 权限数量
     */
    Integer selectCountRolePermission(Map<String,Integer> map);

    /**
     * 删除某一角色的权限
     * @param map key1:角色ID  ;  key2:权限的父类ID(parentId)
     * @return 删除成功 1 ; 删除失败 0
     */
    Integer deleteRolePermission(Map<String,Integer> map);

    /**
     * 为某一角色添加权限
     * @param map ap key1:角色ID  ;  key2:权限的父类ID(parentId)
     * @return 添加成功 1 ; 添加失败 0
     */
    Integer insertRolePermission(Map<String,Integer> map);


}
