package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.UserCondition;
import com.app.mvc.acl.dao.UserDao;
import com.app.mvc.acl.po.User;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void saveUser(User user){
        user.setCreationDate(new Date());
        try {
            userDao.saveUser(user);
        }catch(Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("USER.ADD.FALL");
        }
    }

    @Transactional
    public  void updateUser(User user){
        try {
            userDao.updateUser(user);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("USER.UPDATE.FALL");
        }
    }

    public  User  findById(Integer id){
        User user;
        try{
            user=userDao.findById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("USER.FIND.FALL");
        }
        return user;
    }

    public Page<User> searchUser(UserCondition condition){
        Page<User> userPage=null;
        try{
             int count=userDao.countByUser(condition);
             if(count>0){
                 List<User> list=userDao.searchUser(condition);
                 userPage = Page.<User>builder().total(count).pageNum(condition.getPageNum()).data(list).build();
             }
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("USER.SEARCH.FALL");
        }
        return userPage;
    }


}
