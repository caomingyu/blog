<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp"%>
<%--<%@include file="../include/admin/nav.jsp"%>--%>
<script>
    $(function () {
        $("#addForm").submit(function () {
            if (checkEmpty("name","用户名")) return false;
            if (checkEmpty("password","用户密码")) return false;
            return true;
        });
    });
</script>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <div class="panel-warning"style="margin:160px auto;width: 600px" align="center">
        <div>${message}</div>
        <div class="panel-heading ">登陆</div>
        <div class="panel-body panel-footer">
            <form id="addForm" method="post" action="login">
                <table>
                    <tr>
                        <td>用户账号</td>
                        <td><input type="text" id="name" name="name" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>用户密码</td>
                        <td><input type="text" id="password" name="password" class="form-control"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="提交" class="btn-success">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
