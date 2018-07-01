package com.caomingyu.blog.realm;
 
import java.util.Set;

import com.caomingyu.blog.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
 
import com.caomingyu.blog.service.PermissionService;
import com.caomingyu.blog.service.RoleService;
import com.caomingyu.blog.service.UserService;
 
public class DatabaseRealm extends AuthorizingRealm {
 
    @Autowired
     UserService userService;
    @Autowired
     RoleService roleService;
    @Autowired
     PermissionService permissionService;
     
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        String userName =(String) principalCollection.getPrimaryPrincipal();
        //通过service获取角色和权限
        Set<String> permissions = permissionService.listPermissions(userName);
        Set<String> roles = roleService.listRoles(userName);
         
        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
    }
 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName= token.getPrincipal().toString();
        User u = userService.getByName(userName);
        String passwordInDB = u.getPassword();
        String salt = u.getSalt();
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,passwordInDB,
                ByteSource.Util.bytes(salt),getName());
        return a;
    }
 
}