package com.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 将nacos配置文件注入实体类
 * @author Administrator
 */
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    /**
     * 姓名
     */
    String  name;

    /**
     * 性别
     */
    String sex;

    /**
     * 生日
     */
    String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
