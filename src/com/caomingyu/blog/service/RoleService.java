package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<String> listRoles(String userName);

    Set<String> permissionName(Role role);

    List<Role> list(int uid);

    Set<String> permissionName(List<Role> roles);

    List<Role> list();

//    void setPermission(List<Role> role);

    Role get(int id);
}