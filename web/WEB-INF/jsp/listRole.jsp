<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<html>
<head>
    <title>角色管理</title>
</head>
<script>
    $(function () {
        $("form.addForm").submit(function () {
            if (checkEmpty("name", "角色名")) return false;
            if (checkEmpty("desc_", "角色描述")) return false;
            var value=$("select.selectpicker").selectpicker('val');
            console.log(value)
            $("#selectid").attr("value", value);
            console.log($("#selectid").val())
            if (value==null) {
                alert("权限选择不能为空")
                $(this).focus();
                return false;
            }
            return true;
        });
    });
</script>
<body>
<div style="margin:80px 0 auto;" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">角色管理</span>
</div>
<div>
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">名称</th>
        <th class="success" width="80px">描述</th>
        <th class="success">拥有权限</th>
        <th class="success" width="70px">权限管理</th>
        <th class="success" width="70px">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${rs}" var="r" varStatus="st">
            <tr>
                <td>${r.id}</td>
                <td>${r.name}</td>
                <td>${r.desc_}</td>
                <td>${r.permissionName}</td>
                <td><a href="admin_role_edit?rid=${r.id}"><span
                        class="glyphicon glyphicon-edit"></span></a></td>
                <td><a class="deleteLink" deletelink="true" href="/admin_role_delete?rid=${r.id}"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp" %>
</div>

<div class="panel panel-warning" style="margin:30px auto;width: 500px" align="center">
    <div class="panel-heading">增加角色</div>
    <div class="panel-body panel-footer">
        <form method="post" class="addForm" action="admin_role_add">
            <table>
                <tr>
                    <td>角色名</td>
                    <td><input id="name" type="text" name="name" class="form-control"></td>
                </tr>
                <tr>
                    <td>角色描述</td>
                    <td><input id="desc_" type="text" name="desc_" class="form-control"></td>
                </tr>
                <tr>
                    <td>权限设置</td>
                    <td>
                        <select class="selectpicker" multiple data-actions-box="true"
                                data-none-Selected-Text="请选择角色" data-live-search="true" data-size="4">
                            <c:forEach items="${ps}" var="p">
                                <option value="${p.id}">${p.desc_}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" value="" name="selectid" id="selectid">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="提交" class="btn-success"></td>
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
