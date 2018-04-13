package com.app.mvc.acl.servlet;

import com.app.mvc.acl.condition.UserCondition;
import com.app.mvc.acl.po.User;
import com.app.mvc.acl.service.UserService;
import com.app.mvc.beans.Page;
import com.app.mvc.common.applicationContextHelper;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserCondition condition=new UserCondition();
        condition.setUserName(username);
        Page<User> page=userService.searchUser(condition);
        if(page.getData()==null || page.getData().size()==0){
            throw ServiceException.create("USER.USERNAME.IS.NULL");
        }
        User sysUser=page.getData().get(0);
        if (!sysUser.getEncryptedUserPassword().equalsIgnoreCase(DigestUtils.md5Hex(password))){
            throw ServiceException.create("USER.PWD.IS.FAIL");
        }
        LoginUtil.saveUserToCookie(req,resp,sysUser);


    }
}
