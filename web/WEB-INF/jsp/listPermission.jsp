<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>

<script>
    $(function () {
       $("form.addForm").submit(function () {
            if (checkEmpty("name","权限名字")) return false;
            if (checkEmpty("desc_","权限描述")) return false;
            if (checkEmpty("url","权限url")) return false;
           var url = $("#url").val();
           if (!url.startsWith('/')){
               alert("权限的url必须以 '/' 开头");
               $(this).focus();
               return false;
           }
           return true;
       });
    });
</script>
<html>
<head>
    <title>权限列表</title>
</head>
<body>
<div style="margin:80px 0 auto;" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">权限管理</span>
</div>
<div style="width: 900px;margin:30px auto" align="center">
    <table class="table table-bordered">
        <thead>
        <th class="success">ID</th>
        <th class="success">名字</th>
        <th class="success">描述</th>
        <th class="success">URL</th>
        <th class="success">编辑</th>
        <th class="success">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${ps}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.desc_}</td>
                <td>${p.url}</td>
                <td><a href="/admin_permission_edit?pid=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a class="deleteLink" deletelink="true" href="/admin_permission_delete?pid=${p.id}"><span class="glyphicon glyphicon-remove"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp" %>
</div>

<div class="panel-warning" style="width: 600px;margin:30px auto" align="center">
    <div class="panel-heading">增加权限</div>
    <div class="panel-body panel-footer">
        <form class="addForm" action="/admin_permission_add" method="post">
            <table>
                <tr>
                    <td>名字:</td>
                    <td><input class="form-control" type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <td>描述:</td>
                    <td><input class="form-control" type="text" id="desc_" name="desc_"></td>
                </tr>
                <tr>
                    <td>URL:</td>
                    <td><input class="form-control" type="text" id="url" name="url"></td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" class="btn-success" value="提交">
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
