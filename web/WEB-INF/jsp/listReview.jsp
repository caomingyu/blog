<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp" %>
<%@include file="../include/admin/nav.jsp" %>
<%--<script>--%>
<%--$(function () {--%>
<%--$("#addForm").submit(function () {--%>
<%--if (checkEmpty("ceshi",,"ceshi")) return false;--%>
<%--var html = ue.getContent();--%>
<%--var txt = ue.getContentTxt();--%>
<%--console.log(html);--%>
<%--console.log(txt);--%>
<%--if(html==null||txt==null){--%>
<%--// $("#container").focus();--%>
<%--alert("评论内容不能为空");--%>
<%--return false;--%>
<%--}--%>
<%--$("#context_").attr("value",html);--%>
<%--return false;--%>
<%--});--%>
<%--});--%>
<%--</script>--%>
<html>
<script>
    $(function () {
        $("form.addForm").submit(function () {
            var html = ue.getContent();
            var txt = ue.getContentTxt();
            // if (html == null || txt == null) {
            //     $("#container").focus();
            //     alert("评论内容不能为空");
            //     return false;
            // }
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
<div style="margin-top: 40px">
    <table class="table table-bordered" style="width: 900px" align="center">
        <thead>
        <th class="success">ID</th>
        <th class="success">文章作者</th>
        <th class="success">评论发布者</th>
        <th class="success">评论内容</th>
        <th class="success">发表时间</th>
        </thead>
        <tbody>
        <c:forEach items="${rs}" var="r" varStatus="st">
            <tr>
                <td>${r.id}</td>
                <td>${a.title}</td>
                <td>${u.name}</td>
                <td><a href="admin_review_context?rid=${r.id}"><span class="glyphicon glyphicon-book"></span></a></td>
                <td><fmt:formatDate value="${r.createdate}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:formatDate>
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
