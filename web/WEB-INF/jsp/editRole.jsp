<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/7/4
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<html>
<head>
    <title>编辑角色权限</title>
</head>
<script>
    $(function () {
       $("form.editForm").submit(function () {
            var value=$("select.selectpicker").selectpicker('val');
           console.log(value);
            $("#pid").attr('value',value);
           console.log($("#pid").val())
           return true;
       }); 
    });
</script>
<body>
<div class="panel-warning" style="margin:160px  auto;width: 600px" align="center">
    <div class="panel-heading" align="center">角色权限编辑</div>
    <div class="panel-body panel-footer">
        <form class="editForm" method="post" action="admin_role_update">
            <table>
                <tr>
                    <td>角色名</td>
                    <td><input class="form-control" readonly type="text" id="name" value="${r.name}" name="name"></td>
                </tr>
                <tr>
                    <td>角色描述</td>
                    <td>
                        <input type="text" readonly value="${r.desc_}" class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>权限设置</td>
                    <td>

                        <select class="selectpicker" multiple data-actions-box="true" data-none-Selected-Text="${ps}"
                                data-live-search="true" data-size="4">

                            <c:forEach items="${psAll}" var="p">
                                <option
                                        <c:if test="${fn:contains(s, p.desc_)}">selected="selected"</c:if>
                                        value="${p.id}">${p.desc_}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" id="pid" name="pid" value="">
                        <input type="hidden" id="rid" name="rid" value="${r.id}">
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
