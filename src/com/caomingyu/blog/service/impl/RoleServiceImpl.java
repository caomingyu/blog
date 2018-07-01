package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.RoleMapper;
import com.caomingyu.blog.mapper.UserMapper;
import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.RoleExample;
import com.caomingyu.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Role> list(int uid) {
        List<Role> rs = userMapper.list(uid);
        for (Role r:rs
             ) {
            System.out.println(r.getName());
        }
        return rs;
    }
    @Override
    public Set<String> listRoles(String userName) {
        return null;
    }
}
