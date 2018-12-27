package edu.nbut.project_manage.dao.admin;

import edu.nbut.project_manage.bean.entity.Street;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StreetManageDao {
    /**
     * 查询所有乡镇街道
     * @return 乡镇街道对象集合
     */
    List<Street> selectAllStreet();

    /**
     * 增加一条新街道
     * @param streetTitle
     * @param streetCode
     * @param streetRemarks
     * @return 成功 1 ; 失败 0
     */
    int insertStreet(@Param("streetTitle")String streetTitle,
                     @Param("streetCode")String streetCode,
                     @Param("streetRemarks")String streetRemarks);

    /**
     * 删除一条街道
     * @param streetId
     * @return  成功 1 ; 失败 0
     */
    int deleteStreetByStreetId(Integer streetId);

    /**
     * 编辑街道信息
     * @param streetId
     * @param streetTitle
     * @param streetCode
     * @param streetRemarks
     * @return
     */
    int updateStreet( @Param("streetId")String streetId,
                     @Param("streetTitle")String streetTitle,
                     @Param("streetCode")String streetCode,
                     @Param("streetRemarks")String streetRemarks);
}
