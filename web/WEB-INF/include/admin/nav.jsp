<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<div class="navDiv" style="margin-bottom: 50px">
    <nav class="navbar navbar-fixed-top navbar-inverse">
        <img src="../../img/site/brandsite.png" style="width: 55px" class="pull-left">
        <a class="navbar-brand" href="#"><span style="font-size: larger;font-weight: bolder">论坛后台</span></a>
        <c:if test="${!empty subject.principal }"><span class="navbar-brand" style="font-weight: bolder;color: white">欢迎您，${subject.principal}</span>
            <a href="doLogout" class="navbar-brand"><span style="font-weight: bolder;color: white">退出</span></a></c:if>
        <c:if test="${empty subject.principal}"><a class="navbar-brand"
                                                   href="login">请登录</a>,<a class="navbar-brand" href="#">注册</a></c:if>
        <a class="navbar-brand" href="admin_category_list"><span
                style="font-size: larger;font-weight: bolder">栏目列表</span></a>
        <a class="navbar-brand" href="/admin_user_list"><span style="font-size: larger;font-weight: bolder">用户列表</span></a>
        <a class="navbar-brand" href="/admin_role_list"><span style="font-size: larger;font-weight: bolder">角色管理</span></a>
        <a class="navbar-brand" href="/admin_permission_list"><span style="font-size: larger;font-weight: bolder">权限管理</span></a>
    </nav>
</div>
