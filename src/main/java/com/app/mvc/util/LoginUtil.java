package com.app.mvc.util;

import com.alibaba.druid.support.json.JSONUtils;
import com.app.mvc.acl.dto.LoginUser;
import com.app.mvc.acl.po.User;
import com.app.mvc.acl.dto.CookieUser;
import com.app.mvc.acl.service.UserService;
import com.app.mvc.common.applicationContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.util.Base64;

import javax.servlet.http.Cookie;
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

    private final static String USER_NAME = "laogewen";

    private final static  int  COOKIE_SECONDS=60*60*2;

    public static  void saveUserToCookie(HttpServletRequest request, HttpServletResponse response, User user){
        if(user==null){
            return;
        }
        try{
            String userCookie=generateUserCookie(request,user);
            CookieUtil.setCookie(request,response,USER_NAME,userCookie,COOKIE_SECONDS);
            CookieUtil.setCookie(request,response,USER_NAME_COOKIE,user.getUserName(),COOKIE_SECONDS);
        }catch (Exception e){
            log.error(JacksonUtil.toJSon(user),e);
        }
    }


    public static LoginUser getUserFromCookie(HttpServletRequest request, HttpServletResponse response){
        String userCookie="";
        try{
            Cookie cookie=CookieUtil.getCookie(request,USER_NAME);
            if(cookie==null || StringUtil.isEmpty(cookie.getValue())){
                return LoginUser.fail("未获取到登陆的用户信息,请登录");
            }
            userCookie=cookie.getValue();
            if(!userCookie.startsWith(PREFIX) || !userCookie.endsWith(SUFFIX)){
                return  LoginUser.fail("用户信息效验未通过,请登录");
            }
            userCookie=StringUtil.reverse(userCookie.replace(PREFIX,"").replace(SUFFIX,""));
            String decodeBase64=new String(Base64.decodeBase64(userCookie.replaceAll(DEFAULT,"=").getBytes()));
            CookieUser cookieUser=JacksonUtil.readValue(decodeBase64,CookieUser.class);
            if(cookieUser==null){
                return  LoginUser.fail("获取登陆的用户信息出现问题，请重新登陆");
            }
            long during=System.currentTimeMillis()-cookieUser.getLastLogin();
            if(during / 1000 > COOKIE_SECONDS){
                return LoginUser.fail("当前用户登陆信息已过期，请重新登陆");
            }

            UserService userService= applicationContextHelper.popBean(UserService.class);
            User user=userService.findById(cookieUser.getUserId());
            if(user == null){
                return  LoginUser.fail("当前用户未在系统中查询到，请重新登陆");
            }
            if(!user.getUserName().equals(cookieUser.getUserName())){
                return LoginUser.fail("当前用户名和系统中记录的用户名不一致,请重新登陆");
            }
            String ip=IPUtils.getRemoteIp(request);
            String mac=IPUtils.getMACAddress(ip).replaceAll("-","");
            if(!mac.equals(cookieUser.getMac())){
                log.warn("检测出用户mac地址和cookie中的记录的mac不一致,可能是在拼cookie, username:{}", user.getUserName());
            }
            if (!ip.equals(cookieUser.getIp())) {
                log.error("检测出用户ip地址和cookie中的记录的ip不一致,可能是在拼cookie, username:{}", user.getUserName());
            }
            saveUserToCookie(request,response,user);
            return  LoginUser.success(user);
        }catch (Exception e){
            log.error("handle user cookie error, cookie: {}", userCookie,e);
            return LoginUser.fail("处理用户信息出错,请重新登录");
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
