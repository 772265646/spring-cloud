package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.config.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private UserProperties userProperties;
    @GetMapping("/hello")
    public String hello(String name) {
        // <1> 获得服务 `cloud-provider` 的一个实例
        ServiceInstance instance;
        if (true) {
            // 获取服务 `cloud-provider` 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider");
            // 选择第一个
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("cloud-provider");
        }
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/index/" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "client:" + JSON.toJSONString(userProperties);
    }
}
