package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.UserCondition;
import com.app.mvc.acl.po.User;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@DBRepository
public interface UserDao {

    void  saveUser(User user);

    void  updateUser(User user);

    User  findById(@Param("userId") Integer id);

    int  countByUser(@Param("condition") UserCondition condition);

    List<User> searchUser(@Param("condition") UserCondition condition);

}
