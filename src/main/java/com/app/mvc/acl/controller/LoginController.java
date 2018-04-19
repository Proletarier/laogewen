package com.app.mvc.acl.controller;

import com.app.mvc.acl.po.User;
import com.app.mvc.acl.service.LoginService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.util.JacksonUtil;
import com.app.mvc.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/4/9.
 */

@Controller
@RequestMapping("/resource/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData login(HttpServletRequest request, HttpServletResponse response)throws  Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        User user=JacksonUtil.readValue(sb.toString(),User.class);
        User sysUser=loginService.login(request,response,user);
        return JsonData.success(sysUser);
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        LoginUtil.logout(request,response);
        response.sendRedirect("/app/lgwhoutai/page/login/login.html");

    }


    @ResponseBody
    @RequestMapping(value = "captcha",method = RequestMethod.GET)
    public  void validateCode(HttpServletRequest request,HttpServletResponse response){
        loginService.generate(request,response);
    }


}
