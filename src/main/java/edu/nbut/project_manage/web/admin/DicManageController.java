package edu.nbut.project_manage.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.nbut.project_manage.bean.entity.DicItem;
import edu.nbut.project_manage.bean.entity.DicType;
import edu.nbut.project_manage.service.admin.DicItemService;
import edu.nbut.project_manage.service.admin.DicTypeService;
import edu.nbut.project_manage.utils.DateListToJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class DicManageController {
    @Autowired
    private DicItemService dicItemService;
    @Autowired
    private DicTypeService dicTypeService;
    //##############字典库管理
    @RequestMapping("/dicManage")
    public String streetManage(){
        System.out.println("页面跳转至admin/dicManage");
        return "admin/dicmanage";
    }

    /**
     * 
     * @return
     */
    @RequestMapping(value="selectAllDicType")
    @ResponseBody
    public JSONArray selectAllDicType(){
        List<DicType>list=dicTypeService.selectAllDicType();

        JSONArray array=new JSONArray();
        array=DateListToJson.dateLisToJson(list);
        return array;
    }
    /**
     * 获取所有字典类型，分页显示
     * @param start
     * @param length
     * @param draw
     * @return
     */
    @GetMapping("/selectAllPageDicType")
    @ResponseBody
    public JSONObject selectAllPageDicType(@RequestParam(value="start",required=false) String start, @RequestParam(value="length",required=false) String length, @RequestParam(value="draw",required=false) String draw){
        int startpage=Integer.parseInt(start);
        int total=Integer.parseInt(length);
        PageHelper.startPage(startpage/total+1,total );
        List<DicType> list=dicTypeService.selectAllDicType();
        PageInfo<DicType>pageInfo=new PageInfo<DicType>(list);
        int amount=(int) ((int) (pageInfo.getTotal()-startpage*total)>0 ?startpage*total:pageInfo.getTotal());

        JSONObject obj=new JSONObject();
        obj.put("draw",Integer.parseInt(draw));
        obj.put("recordsTotal",pageInfo.getTotal());
        obj.put("recordsFiltered",pageInfo.getTotal());
        obj.put("data", DateListToJson.dateToJson(list));
        return obj;
    }

    /**
     * 根据字典类型ID,获取所有字典条目
     * @param typeId
     * @return
     */
    @RequestMapping(value="selectAllDicItemJson")
    @ResponseBody
    public JSONObject selectAllDicItemJson(@RequestParam String typeId){
        JSONObject obj=new JSONObject();
        JSONArray array=new JSONArray();
        Map<String, String> map=new HashMap<String, String>();
        map.put("typeId", typeId);
        List<DicItem>list=dicItemService.selectAllDicItem(map);
        array=DateListToJson.dateToJson(list);
        obj.put("data", array);
        return obj;
    }

    /**
     * 添加字典类型
     * @param dictype
     * @return
     */
    @RequestMapping(value="insertOrUpdateDicType")
    @ResponseBody
    public int insertOrUpdateDicType(@RequestBody DicType dictype){
        int i=0;
        if(dictype.getDicTypeId()==null||dictype.getDicTypeId()==0){
            i=dicTypeService.insertDicType(dictype);
        }else{
            i=dicTypeService.updateDicType(dictype);
        }
        return i;
    }

    /**
     * 添加字典条目
     * @param dicItem
     * @return
     */
    @RequestMapping(value="insertDicItem")
    public @ResponseBody int insertDicItem(@RequestBody DicItem dicItem){
        int i=0;
        if(dicItem.getDicItemId()==null||dicItem.getDicItemId()==0){
            i=dicItemService.insertDicItem(dicItem);
        }else{
            i=dicItemService.updateDicItem(dicItem);
        }
        return i;
    }

    /**
     * 根据DicTypeId,删除字典类型
     * @param dicTypeId
     * @return
     */
    @RequestMapping(value="deleteDicType")
    public @ResponseBody int deleteDicType(@RequestParam String dicTypeId){
        if(dicTypeId==null||dicTypeId.equals("")){dicTypeId="0";}
        return dicTypeService.deleteDicTypeById(Integer.parseInt(dicTypeId));
    }

    /**
     * 根据条目ID,删除条目
     * @param dicItemId
     * @return
     */
    @RequestMapping(value="deleteDicItem")
    public @ResponseBody int deleteDicItemById(@RequestParam String dicItemId){
        if(dicItemId==null||dicItemId.equals("")){dicItemId="0";}
        return dicItemService.deleteDicItemById(Integer.parseInt(dicItemId));
    }
}
