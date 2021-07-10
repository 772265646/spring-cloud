package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.cloud.model.UserDto;
import com.cloud.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关接口
 * @author Administrator
 */
@RestController
public class UserController {

    @Reference(version = "1.0")
    private UserService userService;

    @RequestMapping("/user")
    public UserDto setUser(String name,String age){
        UserDto userDto = userService.add(name, age);
        System.out.println("dubbo服务调用成功----返回数据"+JSON.toJSON(userDto));
        return userDto;
    }

    /**
     *热点参数限流
     * 限流名字为张三 一秒最多五次
     * @SentinelResource里面填名字，sentinel后台去配置
     */
    @RequestMapping("/userSentinel")
    @SentinelResource("userSentinel")
    public UserDto setUserSentinel(String name,String age){
        UserDto userDto = userService.add(name, age);
        System.out.println("dubbo服务调用成功----返回数据"+JSON.toJSON(userDto));
        return userDto;
    }


}
