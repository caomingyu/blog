package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.PermissionMapper;
import com.caomingyu.blog.mapper.RoleMapper;
import com.caomingyu.blog.mapper.UserMapper;
import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.RoleExample;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserService userService;
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
    public Set<String> permissionName(List<Role> roles) {
        Set<String> names = new HashSet<>();
        Set<String> oldnames = new HashSet<>();
        for (Role r:roles
             ) {
            oldnames=permissionName(r);
            Iterator<String> it = oldnames.iterator();
            while (it.hasNext()) {
                names.add(it.next());
            }
        }
        System.out.println(names.size());
        return names;
    }

    @Override
    public List<Role> list() {
        RoleExample example = new RoleExample();
        example.setOrderByClause("id");
        List<Role> rs = roleMapper.selectByExample(example);
        return rs;
    }

//    @Override
//    public void setPermission(List<Role> role) {
//        for (Role r:role
//             ) {
//            List<Permission> ps = permissionMapper.list(r.getId());
//            r.setPermissions(ps);
//        }
//    }

    @Override
    public Role get(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public Role get(String name) {
        return roleMapper.get(name);
    }

    @Override
    public void delete(int rid) {
        roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public Set<String> listRoles(String userName) {

        return null;
    }

    @Override
    public Set<String> permissionName(Role role) {
        Set<String> names =new HashSet<>();
        List<Permission> ps = permissionMapper.list(role.getId());
        for (Permission p:ps
             ) {
            names.add(p.getDesc_());
        }
        return names;
    }
}
