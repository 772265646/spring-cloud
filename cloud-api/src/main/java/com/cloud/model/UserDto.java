package com.cloud.model;

import java.io.Serializable;

/**
 * 用户实体类
 * @author Administrator
 */

public class UserDto implements Serializable {
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
