package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.PermissionMapper;
import com.caomingyu.blog.mapper.UserMapper;
import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.pojo.PermissionExample;
import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.service.PermissionService;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    UserService userService;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleService roleService;

    @Override
    public Set<String> listPermissions(String userName) {
        return null;
    }

    @Override
    public List<Permission> list() {
        PermissionExample example = new PermissionExample();
        example.setOrderByClause("id");
        return permissionMapper.selectByExample(example);
    }

    @Override
    public void add(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void delete(int id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission get(int id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public List<Permission> list(Role role) {
        return permissionMapper.list(role.getId());
    }

    @Override
    public boolean needInterceptor(String requestURI) {
        List<Permission> ps = list();
        for (Permission p : ps
                ) {
            if (requestURI.equals(p.getUrl())) return true;
        }
        return false;
    }

    @Override
    public Set<String> listPermissionURLs(String userName) {
        Set<String> urls = new HashSet<>();
        User u = userService.getByName(userName);
        List<Role> rs = roleService.list(u.getId());
        for (Role r : rs
                ) {
            List<Permission> ps = list(r);
            for (Permission p : ps
                    ) {
                urls.add(p.getUrl());
            }
        }
        return urls;
    }
}
