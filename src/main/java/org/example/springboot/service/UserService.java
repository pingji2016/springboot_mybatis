package org.example.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.example.springboot.dao.UserDao;
import org.example.springboot.po.User;
import org.example.springboot.query.UserQuery;
import org.example.springboot.util.AssertUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User queryUserByName(String name) {
        User user = userDao.queryUserByName(name);
        return user;
    }

    @Cacheable(value = "users", key = "#id")
    public User queryUserById(Integer id) {
        User user = userDao.queryUserById(id);
        return user;
    }

    public void save(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()), "密码不能为空");

        User temp = userDao.queryUserByName(user.getUserName());

        AssertUtil.isTrue(null != temp, "用户名已经存在");

        AssertUtil.isTrue(userDao.save(user) < 1, "用户名添加失败");
    }

    public PageInfo<User> queryUserList(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<User>(userDao.queryUserList(userQuery));
    }
}
