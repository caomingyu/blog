<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<script>
    $(function () {
       $("form.editForm").submit(function () {
           var url = $("#url").val();
           if (""!=url&&!url.startsWith('/')) {
               alert("权限的url必须以 '/' 开头");
               $(this).focus();
               return false;
           }
           return true;
       }) ;
    });
</script>
<html>
<head>
    <title>权限编辑</title>
</head>
<body>
<div class="panel-warning" style="margin:130px  auto;width: 600px" align="center">
    <div class="panel-heading">编辑权限</div>
    <div class="panel-body panel-footer">
        <form class="editForm" action="/admin_permission_update" method="post">
            <table>
                <tr>
                    <td>名字</td>
                    <td><input type="text" class="form-control" name="name" value="${p.name}"></td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td><input type="text" class="form-control" name="desc_" value="${p.desc_}">
                        <input type="hidden" class="form-control" name="id" value="${p.id}"></td>
                </tr>
                <tr>
                    <td>URL</td>
                    <td><input type="text" id="url" class="form-control" name="url" value="${p.url}"></td>
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
