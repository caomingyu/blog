package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Set<String> listPermissions(String userName) {
        return null;
    }

    @Override
    public List<Permission> list() {
        return null;
    }

    @Override
    public void add(Permission permission) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Permission get(Long id) {
        return null;
    }

    @Override
    public void update(Permission permission) {

    }

    @Override
    public List<Permission> list(Role role) {
        return null;
    }

    @Override
    public boolean needInterceptor(String requestURI) {
        return false;
    }

    @Override
    public Set<String> listPermissionURLs(String userName) {
        return null;
    }
}
