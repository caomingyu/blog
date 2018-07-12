package com.caomingyu.blog.pojo;

import java.util.List;
import java.util.Set;

public class User {
    private Integer id;
    private Set<String> permissionnames;
    private List<Review> rs;

    public List<Review> getRs() {
        return rs;
    }

    public void setRs(List<Review> rs) {
        this.rs = rs;
    }

    public Set<String> getPermissionnames() {
        return permissionnames;
    }

    public void setPermissionnames(Set<String> permissionnames) {
        this.permissionnames = permissionnames;
    }

    private String name;

    private String password;

    private String salt;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}