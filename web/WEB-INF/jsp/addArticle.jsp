<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../include/admin/head.jsp"%>
<%@include file="../include/admin/nav.jsp"%>
<script>
    $(function () {
        $("#addForm").submit(function () {
            if (checkEmpty("title","文章标题不能为空")) return false;
            if (checkEmpty("keyword","文章关键字不能为空")) return false;
            // if (checkEmpty("context_","文章内容不能为空")) return false;
            var html = ue.getContent();
            // var txt = ue.getContentTxt();
            $("#context_").attr("value",html);
            // alert(html);
            // alert(txt);
            return true;
        });
    });
</script>
<html>
<head>
    <title>增加文章</title>
</head>
<body>
    <nav>
        <ul class="breadcrumb">
            <li style="display: inline-block"><a href="/admin_category_list"><span>${c.name}</span></a></li>
            <li style="display: inline-block" class="active">文章增加</li>
        </ul>
    </nav>

<div class="panel-warning" style="margin:40px auto;width: 900px">
    <div class="panel-heading" align="center">文章增加</div>
    <div class="panel-body" align="center">
        <form id="addForm" action="admin_article_add_" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>标题</td>
                    <td><input  type="text" class="form-control" id="title" name="title"></td>
                    <td><input type="hidden" id="uid" name="uid" value="7"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input type="text" class="form-control" id="keyword" name="keyword"></td>
                    <td><input type="hidden" id="cid" name="category_id" value="${c.id}"></td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td>
                        <script id="container" name="container" type="text/plain">填写文章内容</script>
                        <input type="hidden" id="context_" name="context_" value="">
                        <%@include file="../include/admin/ueditor.jsp"%>
                    </td>
                    <td><input type="hidden" id="viewcount" name="viewcount" value="${0}"></td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <input type="submit" value="提交" class="btn-success"  >
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
