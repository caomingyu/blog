<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<html>

<head>
    <title>list</title>
    <script>
        $(function () {
            $("form.addForm").submit(function () {
                console.log("进入方法")
                if (!checkEmpty("name","分类名称")) return true;
                return false;
            });
        });
    </script>
</head>
<body>

<div style="margin:80px 0 auto;" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">栏目管理</span>
</div>
<div >
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">姓名</th>
        <th class="success">文章</th>
        <th class="success">编辑</th>
        <th class="success">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="admin_article_list?cid=${c.id}"><span class="glyphicon glyphicon-tasks"></span></a></td>
                <td><a href="admin_category_edit?cid=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a  class="deleteLink" cid="${c.id}" as="${c.articles}" deletelink="true" href="admin_category_delete?cid=${c.id}"><span class="glyphicon glyphicon-remove"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp"%>
</div>
<div class="panel panel-warning" style="margin: 40px auto 0;width: 500px" align="center" >
    <div class="panel-heading" align="center">增加分类</div>
    <div class="panel-body" align="center" >
        <form class="addForm" action="/admin_category_add" method="post">
            <table>
                <tr>
                    <td>名称：</td>
                    <td><input class="form-control" id="name" name="name"  type="text"></td>
                </tr>
                <br>
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
    <%@include file="../include/admin/foot.jsp"%>
</div>
</body>
</html>
