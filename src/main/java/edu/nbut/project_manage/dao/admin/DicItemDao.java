package edu.nbut.project_manage.dao.admin;

import edu.nbut.project_manage.bean.entity.DicItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DicItemDao {
    /**
     * 获取条目名称
     * @param dicItemId 词条库表的主键
     * @return
     */
    String selectByPrimaryKey(Integer dicItemId);

    /**
     * 根据DicTypeId,获取所有DicItem
     * @param map
     * @return
     */
    List<DicItem> selectAllDicItem(Map<String ,String> map);
    /**
     * 添加一条字典类型
     *
     * @param dicItem
     */
    int insertDicItem(DicItem dicItem);

    /**
     * 修改字典类型
     *
     * @param dicItem
     * @return
     */
    int updateDicItem(DicItem dicItem);
    /**
     * 根据DicItmeId,删除字典类型
     *
     * @param dicItemId
     * @return
     */
    int deleteDicItemById(Integer dicItemId);

    /**
     * 为了同步操作员类型名字和字典库同步
     * 去数据表DicItem中获取对应的Title值(varchar型数据)
     * @param roleTitle role表中title字段的值
     * @return
     */
    String getRoleTitle(String roleTitle);
}
