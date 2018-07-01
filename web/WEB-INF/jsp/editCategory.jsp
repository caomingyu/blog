<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp"%>
<%@include file="../include/admin/nav.jsp"%>
<html>
<script>
    $(function () {
        $("form.updateForm").submit(function () {
            console.log("进入方法")
            if (!checkEmpty("name","分类名称")) return true;
            return false;
        });
    });
</script>
<head>
    <title>编辑</title>
</head>
<body>
    <div class="panel panel-danger"style="width: 500px;margin: 0 auto;margin-top: 40px">
        <div class="panel-heading" align="center">编辑分类</div>
        <div class="panel-body" align="center" >
            <form class="updateForm" action="/admin_category_update" method="post">
                <table>
                    <tr>
                        <td>名称：</td>
                        <td><input class="form-control" id="name" name="name" value="${c.name}" type="text"></td>
                        <td><input type="hidden" name="id" value="${c.id}"></td>
                    </tr>
                    <br>
                    <tr>
                        <td align="center" colspan="3">
                            <input type="submit" value="提交" class="btn-success">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
<div>
    <%@include file="../include/admin/foot.jsp"%>
</div>
</body>
</html>
