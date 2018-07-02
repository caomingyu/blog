package com.caomingyu.blog.pojo;

import java.util.List;
import java.util.Set;

public class Role {
    private Integer id;

    private String name;
    private Set<String> permissionName;

    public Set<String> getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(Set<String> permissionName) {
        this.permissionName = permissionName;
    }

    private String desc_;
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
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

    public String getDesc_() {
        return desc_;
    }

    public void setDesc_(String desc_) {
        this.desc_ = desc_ == null ? null : desc_.trim();
    }
}