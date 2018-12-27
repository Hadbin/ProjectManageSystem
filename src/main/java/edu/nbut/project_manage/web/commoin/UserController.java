package edu.nbut.project_manage.web.commoin;

import edu.nbut.project_manage.bean.dto.ResultDTO;
import edu.nbut.project_manage.bean.entity.Role;
import edu.nbut.project_manage.bean.entity.UserInfo;
import edu.nbut.project_manage.service.common.UserService;
import edu.nbut.project_manage.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService UserService;
/*
    @RequestMapping(value = "/login")
    public String login(String username, String password,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();

        logger.info("username ====>{} && password ====> {}",username,password);
        ResultDTO resultDTO=UserService.login(username, password);

        model.addAttribute("token",resultDTO.getData().get("token"));
        model.addAttribute("UserInfo",resultDTO.getData().get("UserInfo"));
        model.addAttribute("optionerType",resultDTO.getData().get("optionerType"));
        model.addAttribute("code",resultDTO.getMsg());
        model.addAttribute("resultDTO",resultDTO);
        model.addAttribute("roles",resultDTO.getData().get("roles"));
        *//*我要把functionID传到前端*//*
        session.setAttribute("optionerType",resultDTO.getData().get("optionerType"));
        *//*如果是管理员跳到 admin/userrole*//*
       // return  "admin/userrole";
        return  "admin/userrole";

    }*/

    /**
     * 用户登录
     * @param username
     * @param password
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(String username, String password,HttpSession httpSession,Model model) {
        logger.info("username ====>{} && password ====> {}",username,password);
        UserInfo userInfo=UserService.login(username, password);
        if (userInfo==null){
            return "index";
        }else{
            logger.info("userInfo ====>{}",userInfo);
            //model.addAttribute("userInfo",userInfo);
          //  model.addAttribute("roles",resultDTO.getData().get("roles"));
            httpSession.setAttribute("userInfo",userInfo);
           // httpSession.setAttribute("roles",resultDTO.getData().get("roles"));

            return  "common/blank";
        }
    }

    /**
     * 获取用户的所有权限
     * @param userId 用户ID
     * @return 包含权限集合的角色集
     */
    @RequestMapping(value = "/getUserAllPermission")
    @ResponseBody
    public List<Role> getUserAllPermission(Integer userId){
         List<Role> roles=UserService.getUserAllPermission(userId);
        return roles;
    }


   /* @RequestMapping(value = "/login/token")
    public String token(String token, Model m) {

        logger.info("token ====>{}",token);

       // m.addAttribute("UserInfo", now);
        *//*
        * 需要验证token是否合法
        * *//*
        return  "admin/userrole";
    }*/
}
