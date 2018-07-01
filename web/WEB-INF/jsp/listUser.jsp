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
        <th>姓名</th>
        <th>密码(加密)</th>
        <th>用户角色</th>
        </thead>
        <tbody>
        <c:forEach items="${us}" var="u" varStatus="st">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
                <td>
                    <c:forEach items="${u.roles}" var="r">
                        ${r.desc_}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
