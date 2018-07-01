package com.caomingyu.blog.pojo;


public class User {
    private Integer id;

    private String name;

    private String password;

    private Boolean isadministrator;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getIsadministrator() {
        return isadministrator;
    }

    public void setIsadministrator(Boolean isadministrator) {
        this.isadministrator = isadministrator;
    }
}