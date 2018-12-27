package edu.nbut.project_manage.service.admin;

import edu.nbut.project_manage.bean.entity.DicItem;
import edu.nbut.project_manage.bean.entity.DicType;

import java.util.List;
import java.util.Map;

public interface DicItemService {
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
}
