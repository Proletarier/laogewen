package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.UserCondition;
import com.app.mvc.acl.po.User;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/9.
 */
@Service
public class LoginService {

    @Autowired
    private  UserService userService;


    public  void  lgoin(User loginUser){


        UserCondition condition=new UserCondition();
        condition.setUserName(loginUser.getUserName());
        Page<User> page=userService.searchUser(condition);
        if(page.getData()==null || page.getData().size()==0){
            throw ServiceException.create("USER.USERNAME.IS.NULL");
        }
        User sysUser=page.getData().get(0);
        if (!sysUser.getEncryptedUserPassword().equalsIgnoreCase(DigestUtils.md5Hex(loginUser.getPassword()))){
            throw ServiceException.create("USER.PWD.IS.FAIL");
        }


    }
}



































