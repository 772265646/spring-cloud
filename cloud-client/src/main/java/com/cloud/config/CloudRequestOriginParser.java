package com.cloud.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置黑白名单控制 需要继承sentinel的RequestOriginParser
 * @author Administrator
 */
@Component
public class CloudRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String u = httpServletRequest.getHeader("u");
        if (StringUtils.isEmpty(u)){
            u="default";
        }
        return u;
    }
}
