package com.app.mvc.acl.dto;

import com.app.mvc.acl.po.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/4/18.
 */

@Getter
@Setter
public class LoginUser {

    private boolean ret=false;

    private User user;

    private  String msg;

    public  LoginUser(boolean ret,User user,String msg){
        this.ret=ret;
        this.user=user;
        this.msg=msg;
    }

    public static  LoginUser success(User user){
        return  new LoginUser(true,user,null);
    }

    public static LoginUser fail(String msg){
        return  new LoginUser(false,null,msg);
    }

}
