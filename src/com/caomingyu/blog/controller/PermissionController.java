package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.service.PermissionService;
import com.caomingyu.blog.service.RolePermissionService;
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
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RolePermissionService rolePermissionService;
    @RequestMapping("admin_permission_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Permission> ps = permissionService.list();
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        return "listPermission";
    }
    @RequestMapping("admin_permission_add")
    public String add(Permission permission){
        permissionService.add(permission);
        return "redirect:admin_permission_list";
    }
    @RequestMapping("admin_permission_edit")
    public String edit(int pid,Model model){
        Permission p = permissionService.get(pid);
        model.addAttribute("p", p);
        return "editPermission";
    }
    @RequestMapping("/admin_permission_update")
    public String update(Permission permission){
        if (permission.getName().equals("")) permission.setName(null);
        if (permission.getDesc_().equals("")) permission.setDesc_(null);
        if (permission.getUrl().equals("")) permission.setUrl(null);
        permissionService.update(permission);
        return "redirect:admin_permission_list";
    }
    @RequestMapping("admin_permission_delete")
    public String delete(int pid){
        permissionService.delete(pid);
//        rolePermissionService.
        return "redirect:admin_permission_list";
    }
}
