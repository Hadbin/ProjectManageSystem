package edu.nbut.project_manage.dao.common;

import edu.nbut.project_manage.bean.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface RoleDao {
    /**
     * 获取所有角色
     */
    List<Role> getAllRole();
}
