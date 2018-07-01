<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp"%>
<%@include file="../include/admin/nav.jsp"%>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table class="table">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>用户类型</th>
        </thead>
        <tbody>
        <c:forEach items="${us}" var="u" varStatus="st">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
                <td><c:if test="${u.isadministrator ==true }">管理员</c:if>
                    <c:if test="${u.isadministrator ==false }">普通用户</c:if></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
