<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<html>
<head>
    <title>提示页面</title>
</head>
<body>
<div class="panel panel-warning" style="margin:160px auto;width: 600px" align="center">
    <div class="panel-heading">已经登录过了</div>
    <div class="panel-body panel-footer">
        <table>
            <tr>
                <td>登录者</td>
                <td>${subject.principal}</td>
                <td>
                    <a style="margin-left: 50px" href="doLogout">退出</a>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <button onclick="javascript:history.back()">返回上个页面</button>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
