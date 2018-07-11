<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<script>
    $(function () {
        $("form.editForm").submit(function () {
            var value = $("select.selectpicker").selectpicker('val');
            console.log(value)
            // if (value==null){
            //     alert("角色设置不能为空")
            //     $("select.selectpicker").focus();
            //     return false;
            // }
            console.log(value)
            $("#rid").attr("value", value);
            console.log($("#rid").val())
            return true;
        });

    });
</script>
<html>
<head>
    <title>用户编辑</title>
</head>
<body>
<div class="panel-warning" style="margin:80px  auto;width: 600px" align="center">
    <div class="panel-heading" align="center">用户编辑</div>
    <div class="panel-body panel-footer">
        <form class="editForm" method="post" action="admin_user_update">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input class="form-control" readonly type="text" id="name" value="${u.name}" name="name"></td>
                </tr>
                <tr>
                    <td>角色设置</td>
                    <td>
                        <select class="selectpicker" multiple
                                data-actions-box="true" data-none-Selected-Text="请选择角色" data-live-search="true">
                            <c:forEach items="${rs}" var="r">
                            <option <c:if test="${r.hasintroduced}">selected="selected"</c:if>  value="${r.id}">${r.desc_}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" id="rid" name="rid" value="">
                        <input type="hidden" id="id" name="id" value="${u.id}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="提交" class="btn-success"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
