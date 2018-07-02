<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<script>
    $(function () {
        $("form.addForm").submit(function () {
            if (checkEmpty("name", "用户名")) return false;
            if (checkEmpty("password", "用户密码")) return false;
            var value = $("select.selectpicker").selectpicker('val');
            console.log(value);
            $("#roleid").attr('value', value);
            console.log($("#roleid").val());
            return true;
        });
        // var value = $("span.rdesc_").attr('rid');
        // console.log(value)
        // if (1==value) {
        //     console.log("进入方法")
        //     $("span.permissiondesc").text("");
        //     $("span.show").text('拥有所有权限')
        // }
    });
</script>
<html>
<head>
    <title>list</title>
</head>
<body>
<div style="margin:80px 0 auto;" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">角色管理</span>
</div>
<div>
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">姓名</th>
        <th class="success">密码(加密)</th>
        <th class="success">用户角色</th>
        <th class="success">拥有的权限</th>
        <th width="40px" class="success">编辑</th>
        <th width="40px" class="success">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${us}" var="u" varStatus="st">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
                <td>
                    <c:forEach items="${u.roles}" var="r">
                        <span class="rdesc_" rid="${r.id}">${r.desc_}</span>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${u.permissionnames}" var="s">
                        <span class="permissiondesc" style="display: inline-block">${s}</span>
                    </c:forEach>
                </td>
                <td><a class="deleteLink" detelink="true" href="admin_user_edit?uid=${u.id}"><span
                        class="glyphicon glyphicon-edit"></span></a></td>
                <td><a class="deleteLink" detelink="true" href="admin_user_delete?uid=${u.id}"><span
                        class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp" %>
</div>

<div class="panel panel-warning" style="margin: 40px auto 0;width: 500px" align="center">
    <div class="panel-heading" align="center">增加用户</div>
    <div class="panel-body" align="center">
        <form class="addForm" action="/admin_user_add" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input class="form-control" id="name" name="name" type="text"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input class="form-control" id="password" name="password" type="text"></td>
                </tr>
                <tr>
                    <td>设置角色：</td>
                    <td>
                        <select id="selectroles" class="selectpicker" multiple data-actions-box="true"
                                data-none-Selected-Text="请选择角色" data-live-search="true">
                            <c:forEach items="${roles}" var="r">
                                <option rid="${r.id}" name="role" value="${r.id}">${r.desc_}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="hidden" id="roleid" name="roleid" value=""></td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" value="提交" class="btn-success">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div>
    <%@include file="../include/admin/foot.jsp" %>
</div>

</body>
</html>
