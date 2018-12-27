package edu.nbut.project_manage.service.admin.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.nbut.project_manage.bean.entity.Street;
import edu.nbut.project_manage.dao.admin.StreetManageDao;
import edu.nbut.project_manage.service.admin.StreetManageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetManageServiceImpl  implements StreetManageService {
    @Autowired
    private StreetManageDao streetManageDao;
    @Override
    public JSONObject selectAllStreet(Integer startpage, Integer total, Integer draw) {
        JSONObject json = new JSONObject();
        PageHelper.startPage(startpage / total + 1, total);
        List<Street> streets = streetManageDao.selectAllStreet();
        System.out.println("Streets="+streets);
        PageInfo<Street> pageInfo = new PageInfo<Street>(streets);
        JSONArray array = ListToTableJson(streets);
        json.put("draw", draw);
        json.put("recordsTotal", pageInfo.getTotal());
        json.put("recordsFiltered", pageInfo.getTotal());
        json.put("data", array);
        return json;
    }

    @Override
    public int insertStreet(String streetTitle, String streetCode, String streetRemarks) {
        return streetManageDao.insertStreet(streetTitle,streetCode,streetRemarks);
    }

    @Override
    public int deleteStreetByStreetId(Integer streetId) {
        return streetManageDao.deleteStreetByStreetId(streetId);
    }

    @Override
    public int updateStreet(String streetId, String streetTitle, String streetCode, String streetRemarks) {

        return streetManageDao.updateStreet(streetId,streetTitle,streetCode,streetRemarks);
    }
    //#####只在本类中用到的方法
    /**
     * 返回的数据转化成表格的json形式
     *
     * @param list
     * @returnI
     */
    private JSONArray ListToTableJson(List<Street> list) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject json = new JSONObject();
            json.put("streetId", list.get(i).getStreetId());
            json.put("streetTitle", list.get(i).getTitle());
            json.put("streetCode", list.get(i).getCode());
            json.put("streetRemarks", list.get(i).getRemarks());
            array.add(json);
        }
        return array;
    }

}
