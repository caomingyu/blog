package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.RolePermission;

public interface RolePermissionService {
    void delete(int rid);

    void add(RolePermission rolePermission);

    void deleteByPid(int pid);
}
