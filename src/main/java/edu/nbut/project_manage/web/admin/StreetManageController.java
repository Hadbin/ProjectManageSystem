package edu.nbut.project_manage.web.admin;

import edu.nbut.project_manage.service.admin.StreetManageService;
import edu.nbut.project_manage.web.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class StreetManageController extends BaseController {
    @Autowired
    private StreetManageService  streetManageService;
    //##############乡镇街道管理
    @RequestMapping("/streetManage")
    public String streetManage(){
        System.out.println("页面跳转至admin/streetmanage");
        return "admin/streetmanage";
    }

    @GetMapping("/selectAllStreet")
    @ResponseBody
    public JSONObject selectAllStreet(@RequestParam(value = "start", required = false) String start,
                                 @RequestParam(value = "length", required = false) String length,
                                 @RequestParam(value = "draw", required = false) String draw_
    ) {
        int startpage = Integer.parseInt(start);
        int total = Integer.parseInt(length);
        int draw = Integer.parseInt(draw_);
        JSONObject json = streetManageService.selectAllStreet(startpage, total, draw);
        System.out.println("getAllStreet=" + json);
        return json;
    }

    @PostMapping("/insertStreet")
    @ResponseBody
    public int insertStreet(@RequestParam(value = "streetTitle", required = false) String streetTitle,
                            @RequestParam(value = "streetCode", required = false) String streetCode,
                            @RequestParam(value = "streetRemarks", required = false) String streetRemarks
                            ){
        return streetManageService.insertStreet(streetTitle,streetCode,streetRemarks);
    }

    @GetMapping("/deleteStreetByStreetId")
    @ResponseBody
    public int deleteStreetByStreetId(Integer streetId){
        return streetManageService.deleteStreetByStreetId(streetId);
    }
    @PostMapping("/updateStreet")
    @ResponseBody
    public int updateStreet(@RequestParam(value = "streetId", required = false) String streetId,
                            @RequestParam(value = "streetTitle", required = false) String streetTitle,
                            @RequestParam(value = "streetCode", required = false) String streetCode,
                            @RequestParam(value = "streetRemarks", required = false) String streetRemarks

    ){

        if(streetRemarks ==null ){
            streetRemarks="";
        }
        return streetManageService.updateStreet(streetId,streetTitle,streetCode,streetRemarks);
    }

}
