package edu.nbut.project_manage.service.admin.impl;

import edu.nbut.project_manage.bean.entity.DicItem;
import edu.nbut.project_manage.dao.admin.DicItemDao;
import edu.nbut.project_manage.dao.admin.DicTypeDao;
import edu.nbut.project_manage.service.admin.DicItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DicItemServiceImpl implements DicItemService {
    @Autowired
    private DicItemDao dicItemDao;
    @Override
    public List<DicItem> selectAllDicItem(Map<String, String> map) {
        return dicItemDao.selectAllDicItem(map);
    }

    @Override
    public int insertDicItem(DicItem dicItem) {
        return dicItemDao.insertDicItem(dicItem);
    }

    @Override
    public int updateDicItem(DicItem dicItem) {
        return dicItemDao.updateDicItem(dicItem);
    }

    @Override
    public int deleteDicItemById(Integer dicItmeId) {
        return dicItemDao.deleteDicItemById(dicItmeId);
    }
}
