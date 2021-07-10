package com.cloud.service;

import com.cloud.model.UserDto;
import org.apache.dubbo.config.annotation.Service;

/**
 * 服务实现
 * @author Administrator
 */
@Service(protocol = "dubbo",version ="1.0")
public class UserServiceImpl implements UserService {
    @Override
    public UserDto add(String name, String age)  {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setAge(age);
        return userDto;
    }
}
