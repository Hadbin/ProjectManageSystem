package edu.nbut.project_manage.dao.common;

import edu.nbut.project_manage.bean.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnitDao {
    /**
     * 获取所有单位的信息
     * @return
     */
    List<Unit> selectAllUnit();

    /**
     * 获取单位信息
     * @param unitId 单位Id
     * @return 单位
     */
    Unit getUnitInfoById(Integer unitId);

    /**
     * 通过用户ID，修改单位名字
     * @param title 单位名字
     * @param userId 用户ID
     * @return
     */
    int updateUnitTitle(@Param("title")String title, @Param("userId")String userId);

    /**
     * 获取用户的单位名称
     * @param userId
     * @return
     */
    String getUnitTitle(Integer userId);
}
