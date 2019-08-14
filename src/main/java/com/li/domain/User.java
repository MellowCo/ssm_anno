package com.li.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private Integer id;
    @Size(min = 3,max = 5,message = "{user.name.length.error}")
    private String name;

    @NotNull(message = "{user.sex.notnull.error}")
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}