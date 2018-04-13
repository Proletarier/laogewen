package com.app.mvc.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/4/12.
 */
public class CookieUtil {

    public static String getCookieValue(Cookie[] cookies,String name){

        if(cookies==null){
            return null;
        }
        for (Cookie cookie: cookies){
             if(name.equals(cookie.getName())){
                return   cookie.getValue();
             }
        }
        return  null;

    }

    public static  Cookie getCookie(HttpServletRequest request,String cookieName){
        Cookie[] cookies=request.getCookies();

        if (cookies==null){
            return  null;
        }
        Cookie cookie=null;
        for (Cookie ck : cookies){
            if(cookieName.equals(ck.getName())){
                cookie=ck;
            }
        }
        return  cookie;
    }

    public  static  void  writeTouchCookie(HttpServletRequest request, HttpServletResponse response,int maxAge,String cName,String cValue,String domain){
            Cookie cookie=CookieUtil.getCookie(request,cName);
            if(cookie==null){
                cookie=new Cookie(cName,cValue);
            }else {
                cookie.setValue(cValue);
            }
            cookie.setMaxAge(maxAge);
            cookie.setPath("/");
            cookie.setDomain(domain);
            response.addCookie(cookie);
    }


    public static  void  setCookie(HttpServletRequest request,HttpServletResponse response,String cName,String cValue,int maxAge){
        Cookie cookie=new Cookie(cName,cValue==null? "":cValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath(getPath(request));
        response.addCookie(cookie);
    }


    public  static  String getPath(HttpServletRequest request){
        String path=request.getContextPath();
        return  (path==null || path.length()==0) ? "/":path;
    }




}
