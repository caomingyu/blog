package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User getByName(String name);
    User get(int id);
    void delete(int id);
    void add(User user);

    User get(String name);
}
