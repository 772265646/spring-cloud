package com.cloud.service;


import com.cloud.model.UserDto;

/**
 * 测试dubbo接口
 * @author Administrator
 */
public interface UserService {

    /**
     * 添加用户信息
     * @param name 名字
     * @param age 性别
     * @return 返回值
     */
    UserDto add(String name, String age) ;
}
