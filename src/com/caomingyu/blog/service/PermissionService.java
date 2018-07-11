package com.caomingyu.blog.service;
 
import java.util.List;
import java.util.Set;
 
import com.caomingyu.blog.pojo.Permission;
import com.caomingyu.blog.pojo.Role;

public interface PermissionService {
    public Set<String> listPermissions(String userName);
 
    public List<Permission> list();
 
    public void add(Permission permission);
 
    public void delete(int id);
 
    public Permission get(int id);
 
    public void update(Permission permission);
 
    public List<Permission> list(Role role);
 
    public boolean needInterceptor(String requestURI);
 
    public Set<String> listPermissionURLs(String userName);
 
}