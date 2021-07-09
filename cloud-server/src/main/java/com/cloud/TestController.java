package com.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @author Administrator
 */
@RestController
@RequestMapping("/index")
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello spring cloud provider";
    }
}
