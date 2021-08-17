package org.example.springboot.dao;

import org.example.springboot.po.User;
import org.example.springboot.query.UserQuery;

import java.util.List;

public interface UserDao {
    public User queryUserByName(String userName);

    public User queryUserById(Integer id);

    public int save(User user);


    //分页
    public List<User> queryUserList(UserQuery userQuery);
}
