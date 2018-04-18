package com.app.mvc.acl.filter;

import com.app.mvc.acl.dto.LoginUser;
import com.app.mvc.util.IPUtils;
import com.app.mvc.util.LoginUtil;
import com.app.mvc.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/3/23.
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String servletPath=request.getServletPath();
        String ip= IPUtils.getUserIp(request);

         LoginUser loginUser=LoginUtil.getUserFromCookie(request,response);
         if(loginUser==null || !loginUser.isRet() || loginUser.getUser() ==null){
             String ret=request.getRequestURI();
             String parameterString=request.getQueryString();
             if(parameterString!=null){
                 ret +="?" + parameterString;
             }
             response.sendRedirect("/app/lgwhoutai/page/login/login.html?ret="+ URLEncoder.encode(ret));
         }

         filterChain.doFilter(request,response);
         return;
    }

    @Override
    public void destroy() {

    }

}
