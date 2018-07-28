package com.oocl.admin.interceptor;

import com.oocl.admin.enums.ResultStatusEnum;
import com.oocl.admin.util.CookieUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtil.getCookieValue(request, "token");
        String requestURI = request.getRequestURI();

        for (String url : exceptUrls) {
            if (requestURI.startsWith(url)) { //不拦截的请求
               return true;
            }
        }

        //cookie为空，没有登陆
        if (StringUtils.isBlank(token)) {
            response.setStatus(ResultStatusEnum.UNAUTHORIZED.getCode());
            return false;
        }

        String id = (String) request.getSession().getAttribute("login:admin:" + token);
        //登陆过期
        if (StringUtils.isBlank(id)) {
            response.setStatus(ResultStatusEnum.UNAUTHORIZED.getCode());
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }
}
