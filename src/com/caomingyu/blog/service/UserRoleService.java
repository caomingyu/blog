package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    void add(UserRole userRole);

    void delete(int id);

    void update(UserRole userRole);

    UserRole get(int id);

//    List<UserRole> list();
}
