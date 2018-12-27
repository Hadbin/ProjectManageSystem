package edu.nbut.project_manage.service.admin.impl;

import edu.nbut.project_manage.bean.entity.DicType;
import edu.nbut.project_manage.dao.admin.DicTypeDao;
import edu.nbut.project_manage.service.admin.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicTypeServiceImpl implements DicTypeService {
    @Autowired
    private DicTypeDao dicTypeDao;

    @Override
    public List<DicType> selectAllDicType() {
        return dicTypeDao.selectAllDicType();
    }

    @Override
    public int insertDicType(DicType dicType) {
        return dicTypeDao.insertDicType(dicType);
    }

    @Override
    public int updateDicType(DicType dicType) {
        return dicTypeDao.updateDicType(dicType);
    }

    @Override
    public int deleteDicTypeById(Integer dicTypeId) {
        return dicTypeDao.deleteDicTypeById(dicTypeId);
    }

}
