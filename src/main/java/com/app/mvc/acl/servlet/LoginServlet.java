package com.app.mvc.acl.servlet;

import com.app.mvc.acl.po.User;
import com.app.mvc.acl.service.UserService;
import com.app.mvc.common.applicationContextHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/23.
 */
@Slf4j
public class LoginServlet extends HttpServlet {

    private UserService userService=applicationContextHelper.popBean(UserService.class);

     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
