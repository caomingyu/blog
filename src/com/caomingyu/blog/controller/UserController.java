package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.pojo.UserRole;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserRoleService;
import com.caomingyu.blog.service.UserService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> us = userService.list();
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        for (User u : us
                ) {
            u.setRoles(roleService.list(u.getId()));
            Set<String> names = new HashSet<>();
            if (null != u.getRoles()) names = roleService.permissionName(u.getRoles());
            u.setPermissionnames(names);
        }
        List<Role> rs = roleService.list();
        model.addAttribute("us", us);
        model.addAttribute("roles", rs);
        model.addAttribute("page", page);
        return "listUser";
    }
    @RequestMapping("admin_user_add")
    public String add(User u,String roleid){
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int time = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, u.getPassword(), salt, time).toString();
        u.setPassword(encodedPassword);
        u.setSalt(salt);
        userService.add(u);
        User u1 = userService.get(u.getName());
        String []rid=roleid.split(",");
        UserRole userRole = new UserRole();
        userRole.setUid(u1.getId());
        for (String s:rid
             ) {
            userRole.setRid(Integer.valueOf(s));
            userRoleService.add(userRole);
        }
        return "redirect:admin_user_list";
    }
    @RequestMapping("admin_user_edit")
    public String edit(Model model,int uid){
        User u = userService.get(uid);
        List<Role> rs = roleService.list();
        List<Role> hasRole = roleService.list(uid);
        String s="";
        for (int i = 0; i <hasRole.size() ; i++) {
            if (i==hasRole.size()-1){
                s += hasRole.get(i);
                continue;
            }
            s += hasRole.get(i)+",";
        }
        model.addAttribute("rs", rs);
        model.addAttribute("s", s);
        model.addAttribute("u", u);
        return "editUser";
    }

    @RequestMapping("admin_user_update")
    public String update(int id,String rid) {
        if ("".equals(rid)) return "redirect:admin_user_list";
        String[] s = rid.split(",");
        userRoleService.delete(id);
        UserRole userRole = new UserRole();
        userRole.setUid(id);
        for (String s1:s
             ) {
            userRole.setRid(Integer.valueOf(s1));
            userRoleService.add(userRole);
        }
        return "redirect:admin_user_list";
    }
}
