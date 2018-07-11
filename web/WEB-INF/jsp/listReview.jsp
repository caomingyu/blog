<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<html>
<script>
    $(function () {
        $("form.addForm").submit(function () {
            var html = ue.getContent();
            var txt = ue.getContentTxt();
            $("#context_").attr("value", html);
            var value = $("#context_").val();
            if (checkEmpty("context_","评论内容")) return false;
            return true;
        });
    });
</script>
<head>
    <title>评论列表</title>
</head>
<body>
<nav>
    <ul class="breadcrumb">
        <li><a href="admin_category_list">${c.name}</a></li>
        <li><a href="admin_article_list?cid=${c.id}">${a.title}</a></li>
        <li class="active">评论列表</li>
    </ul>
</nav>
<div style="" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">评论管理</span>
</div>
<div >
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">文章作者</th>
        <th class="success">评论发布者</th>
        <th class="success">评论内容</th>
        <th class="success">发表时间</th>
        <th class="success">编辑</th>
        <th class="success">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${rs}" var="r" varStatus="st">
            <tr>
                <td>${r.id}</td>
                <td>${u.name}</td>
                <td>${r.user.name}</td>
                <td><a href="admin_review_context?rid=${r.id}"><span class="glyphicon glyphicon-book"></span></a></td>
                <td><fmt:formatDate value="${r.createdate}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td><a href="/admin_review_edit?rid=${r.id}"><span class="glyphicon glyphicon-edit"></span></a>
                </td>
                <td><a class="deleteLink" deletelink="true" href="/admin_review_delete?rid=${r.id}"><span class="glyphicon glyphicon-remove"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp" %>
</div>
<div class="panel panel-warning" style="margin: 40px auto 0;width: 500px" align="center">
    <div class="panel-heading" align="center">增加评论</div>
    <div class="panel-body" align="center">
        <form class="addForm" id="addForm" action="/admin_review_add" method="post">
            <table>
                <tr>
                    <td><input id="article_id" value="${a.id}" name="article_id" type="hidden"></td>
                </tr>
                <tr>
                    <td>评论内容</td>
                    <td>
                        <script id="container" name="container" type="text/plain">填写评论内容</script>
                        <input type="hidden" id="context_" name="context_" value="">
                        <%@include file="../include/admin/ueditor.jsp" %>
                    </td>
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
