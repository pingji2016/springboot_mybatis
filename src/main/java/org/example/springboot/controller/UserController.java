package org.example.springboot.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.springboot.exception.ParamsException;
import org.example.springboot.po.User;
import org.example.springboot.po.vo.ResultInfo;
import org.example.springboot.query.UserQuery;
import org.example.springboot.service.UserService;
import org.example.springboot.util.AssertUtil;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "用户模块")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("user/name/{uname}")
    @ApiOperation(value = "查询用户通过name", notes = "非空")
    @ApiImplicitParam(name = "uname", value = "用户uname", required = true, dataType = "String", paramType = "path")
    public User queryUserByName(@PathVariable String uname) {
        User user = userService.queryUserByName(uname);
        return user;
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "查询用户通过id")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    public User queryUserById(@PathVariable Integer id) {
        System.out.println("name id @#@#   1323123123123  == " + id);
        AssertUtil.isTrue(true, "自定义");

        User user = userService.queryUserById(id);
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("user")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user", value = "user名字", required = true, dataType = "User")
    public ResultInfo addUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();

        try {
            userService.save(user);
        } catch (ParamsException p) {
            p.printStackTrace();
            resultInfo.setCode(p.getCode());
            resultInfo.setMsg(p.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setMsg("失败");
            resultInfo.setCode(300);
        }
        return resultInfo;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("user02")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user", value = "user名字", required = true, dataType = "User")
    public ResultInfo addUser02(@Valid User user) {
        ResultInfo resultInfo = new ResultInfo();


        return resultInfo;
    }

    @GetMapping("user/list")
    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParam(name = "userQuery", value = "用户id")
    public PageInfo<User> queryUserList(UserQuery userQuery) {
        return userService.queryUserList(userQuery);
    }
}
