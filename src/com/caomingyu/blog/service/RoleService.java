package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<String> listRoles(String userName);

    List<Role> list(int uid);
}