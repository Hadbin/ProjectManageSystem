package edu.nbut.project_manage.filter;

import edu.nbut.project_manage.bean.dto.ResultDTO;
import edu.nbut.project_manage.enums.DataDictionary;
import edu.nbut.project_manage.filter.utils.PermissionUtils;
import edu.nbut.project_manage.utils.JWTUtils;
import edu.nbut.project_manage.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class MyHandlerInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /*
     *
     * 这里我们需要实现HandlerInterceptor这个接口，
     * 这个接口包括三个方法，preHandle是请求执行前执行的，postHandler是请求结束执行的，
     * 但只有preHandle方法返回true的时候才会执行，afterCompletion是视图渲染完成后才执行，
     * 同样需要preHandle返回true，该方法通常用于清理资源等工作。
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {


        System.out.println("== 除了/user/login路径的过滤器 ==");
        ResultDTO resultDto = new ResultDTO();
        // 获取前端提交的令牌
        String jwt = request.getHeader("Authorization");
        String jwt2 = request.getHeader("data");
        System.out.println(jwt2);
        // 解析令牌的数据
        logger.info("##### token ====> {} ####", jwt);
        Map<String, Object> claims = JWTUtils.verifyJWT(jwt);
        if (claims == null) {
            System.out.println("解析令牌的数据失败");
            PrintWriter out = response.getWriter();

            // 令牌解析失败
            resultDto.setCodeAndMsg(DataDictionary.AUTHORIZATION_FAIL);
            out.print(JacksonUtils.toJSon(resultDto));
            out.flush();
            out.close();
            return false;
        }
        Integer userId = (Integer) claims.get("userId");
        if (userId == null) {
            PrintWriter out = response.getWriter();
            // 无效令牌
            System.out.println("无效令牌");
            resultDto.setCodeAndMsg(DataDictionary.AUTHORIZATION_FAIL);
            out.print(JacksonUtils.toJSon(resultDto));
            out.flush();
            out.close();
            return false;
        }

        if (!PermissionUtils.isUserExists(userId)) {
            PrintWriter out = response.getWriter();

            // 用户不存在
            System.out.println("用户不存在");
            resultDto.setCodeAndMsg(DataDictionary.USER_NOT_EXISTS);
            out.print(JacksonUtils.toJSon(resultDto));
            out.flush();
            out.close();
            return false;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}

