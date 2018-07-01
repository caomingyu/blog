package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> us = userService.list();
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        for (User u:us
             ) {
            u.setRoles(roleService.list(u.getId()));
        }
        model.addAttribute("us", us);
        model.addAttribute("page", page);
        return "listUser";
    }
}
