package com.os4t.modules.app.controller;


import com.os4t.common.utils.Result;
import com.os4t.modules.app.annotation.Login;
import com.os4t.modules.app.annotation.LoginUser;
import com.os4t.modules.app.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP测试接口
 *
 * @author  18256595192@163.com
 *
 */
@RestController
@RequestMapping("/app")
@Api("APP测试接口")
public class AppTestController {

    @Login
    @GetMapping("userInfo")
    @ApiOperation("获取用户信息")
    public Result userInfo(@LoginUser UserEntity user){
        return Result.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public Result userInfo(@RequestAttribute("userId") Integer userId){
        return Result.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public Result notToken(){
        return Result.ok().put("msg", "无需token也能访问。。。");
    }

}
