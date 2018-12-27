package edu.nbut.project_manage.service.admin;

import edu.nbut.project_manage.bean.entity.DicType;

import java.util.List;

public interface DicTypeService {

    /**
     * 获取所有字典类型
     *
     * @return list<DicType>
     */
    List<DicType> selectAllDicType();

    /**
     * 添加一条字典类型
     *
     * @param dicType
     */
    int insertDicType(DicType dicType);

    /**
     * 修改字典类型
     *
     * @param dicType
     * @return
     */
    int updateDicType(DicType dicType);

    /**
     * 根据DicTypeId,删除字典类型
     *
     * @param dicTypeId
     * @return
     */
    int deleteDicTypeById(Integer dicTypeId);


}
