package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.pojo.Role;
import com.caomingyu.blog.pojo.RolePermission;
import com.caomingyu.blog.pojo.UserRole;
import com.caomingyu.blog.service.PermissionService;
import com.caomingyu.blog.service.RolePermissionService;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserRoleService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    UserRoleService userRoleService;
    @RequestMapping("admin_role_list")
    public String list(Page page, Model model){
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Role> rs = roleService.list();
        int total = (int) new PageInfo<>(rs).getTotal();
        page.setTotal(total);
        List<Permission> ps = permissionService.list();
        for (Role r:rs
             ) {
            Set<String> psName = roleService.permissionName(r);
            r.setPermissionName(psName);
        }
        model.addAttribute("rs", rs);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        return "listRole";
    }
    @RequestMapping("admin_role_edit")
    public String edit(int rid,Model model){
        Role r = roleService.get(rid);
        List<Permission> ps = permissionService.list(r);
        String s = "";
        for (Permission p: ps
             ) {
            s += p.getDesc_()+",";
        }
        r.setPermissions(ps);
        List<Permission> psAll = permissionService.list();
        model.addAttribute("s", s);
        model.addAttribute("psAll", psAll);
        model.addAttribute("r", r);
        return "editRole";
    }
    @RequestMapping("admin_role_update")
    public String update(int rid,String pid){
        if ("".equals(pid)) return "redirect:admin_role_list";
        rolePermissionService.delete(rid);
        String[] s = pid.split(",");
        RolePermission rolePermission=new RolePermission();
        rolePermission.setRid(rid);
        for (String s1:s
             ) {
            rolePermission.setPid(Integer.valueOf(s1));
            rolePermissionService.add(rolePermission);
        }
        return "redirect:admin_role_list";
    }
    @RequestMapping("admin_role_add")
    public String add(Role role,String name,String selectid){
        if ("".equals(selectid)) return "redirect:admin_role_list";
        roleService.add(role);
        Role r = roleService.get(name);
        String[] s = selectid.split(",");
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRid(r.getId());
        for (String s1:s
             ) {
            rolePermission.setPid(Integer.valueOf(s1));
            rolePermissionService.add(rolePermission);
        }
        return "redirect:admin_role_list";
    }
    @RequestMapping("admin_role_delete")
    public String delete(int rid){
        roleService.delete(rid);
        userRoleService.deleteByRid(rid);
        rolePermissionService.delete(rid);
        Role role = roleService.get("user");
        List<UserRole> urs = userRoleService.getByRid(rid);
        for (UserRole ur:urs
             ) {
            ur.setRid(role.getId());
            userRoleService.update(ur);
        }

        return "redirect:admin_role_list";
    }
}
