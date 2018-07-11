package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.RolePermissionMapper;
import com.caomingyu.blog.pojo.RolePermission;
import com.caomingyu.blog.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionSeriveImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Override
    public void delete(int rid) {
        rolePermissionMapper.delete(rid);
    }

    @Override
    public void add(RolePermission rolePermission) {
        rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public void deleteByPid(int pid) {
        rolePermissionMapper.deleteByPid(pid);
    }

}
