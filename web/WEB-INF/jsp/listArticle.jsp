<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<html>
<head>
    <title>文章列表</title>
    <script>
        $(function () {
            $("form.addForm").submit(function () {
                console.log("进入方法")
                if (!checkEmpty("name", "分类名称")) return true;
                return false;
            });
        });
    </script>
</head>
<body>
<nav class="breadcrumb">
        <li><a href="/admin_category_list">${c.name}</a></li>
        <li class="active">文章管理</li>
</nav>
<div style="margin:80px 0 auto;" align="center">
    <span style="font-weight: bolder;color: #2b669a;font-size: larger">文章管理</span>
</div>
<div >
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">标题</th>
        <th class="success">关键词</th>
        <th class="success">作者</th>
        <th class="success">内容</th>
        <th class="success">评论</th>
        <th class="success">创建时间</th>
        <th class="success">编辑</th>
        <th class="success">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${as}" var="a" varStatus="st">
            <tr>
                <td>${a.id}</td>
                <td>${a.title}</td>
                <td>${a.keyword}</td>
                <td>${a.user.name}</td>
                <td><a href="admin_article_context?aid=${a.id}"><span class="glyphicon glyphicon-book"></span></a></td>
                <td><a href="admin_review_list?aid=${a.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                <td><fmt:formatDate value="${a.createdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><a href="admin_article_edit?aid=${a.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a class="deleteLink" aid="${a.id}" rs="${a.rs}" deletelink="true" href="admin_article_delete?aid=${a.id}"><span class="glyphicon glyphicon-remove"></span></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <%@include file="../include/admin/page.jsp" %>
</div>
<div class="panel-warning" style="width: 600px;margin:40px auto">
    <div class="panel-heading"align="center">文章增加</div>
    <div class="panel-body" align="center">
        <a href="admin_article_add?cid=${c.id}">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </div>
</div>
<div>
    <%@include file="../include/admin/foot.jsp" %>
</div>
</body>
