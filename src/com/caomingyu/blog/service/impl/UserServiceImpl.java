package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.UserMapper;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.pojo.UserExample;
import com.caomingyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id");
        List<User> us = userMapper.selectByExample(example);
        return us;
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
