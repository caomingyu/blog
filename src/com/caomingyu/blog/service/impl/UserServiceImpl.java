package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.UserMapper;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.pojo.UserExample;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleService roleService;
    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id");
        List<User> us = userMapper.selectByExample(example);
        return us;
    }

    @Override
    public User getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> us = userMapper.selectByExample(example);
        return us.get(0);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public User get(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> us = userMapper.selectByExample(example);
        if (us==null) return null;
        return us.get(0);
    }
}
