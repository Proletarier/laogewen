package com.app.mvc.util;

import com.alibaba.druid.support.json.JSONUtils;
import com.app.mvc.acl.po.User;
import com.app.mvc.beans.CookieUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/4/12.
 */

@Slf4j
public class LoginUtil {


    private final static String DEFAULT = "@6CFB18E2#iLpYs8Tb";

    private final static String PREFIX = "9c0Mk$%S9mD&Yu";

    private final static String SUFFIX = "uIml&8k#pI92*Qr";

    private final static String USER_NAME_COOKIE = "_UN";

    private final static  int  COOKIE_SECONDS=60*60*2;

    public static  void saveUserToCookie(HttpServletRequest request, HttpServletResponse response, User user){
        if(user==null){
            return;
        }
        try{
            String userCookie=generateUserCookie(request,user);
            CookieUtil.setCookie(request,response,"wen",userCookie,COOKIE_SECONDS);
            CookieUtil.setCookie(request,response,USER_NAME_COOKIE,user.getUserName(),COOKIE_SECONDS);
        }catch (Exception e){
            log.error(JacksonUtil.toJSon(user),e);
        }
    }


    public  static String generateUserCookie(HttpServletRequest request,User user){
        String ip=IPUtils.getRemoteIp(request);
        String mac=IPUtils.getMACAddress(ip).replaceAll("-","");
        CookieUser cookieUser=CookieUser.builder().userId(user.getUserId()).userName(user.getUserName()).ip(ip).mac(mac).build();
        String encodeBase= Base64.encodeBase64String((JSONUtils.toJSONString(cookieUser).getBytes())).replaceAll("=",DEFAULT);
        encodeBase=StringUtil.reverse(encodeBase);
        encodeBase=PREFIX+encodeBase+SUFFIX;
        return  encodeBase;
    }


























}
