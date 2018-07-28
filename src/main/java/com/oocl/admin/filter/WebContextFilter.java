package com.oocl.admin.filter;

import com.oocl.admin.util.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "WebContextFilter")
public class WebContextFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse response = (HttpServletResponse) resp;

        response.setContentType("text/html;charset=UTF-8");

        response.setHeader("Access-Control-Allow-Origin", PropertiesUtil.getProperty("admin.front.url"));

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, DELETE, PUT, PATCH");

        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("XDomainRequestAllowed","1");

        chain.doFilter(req, response);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
