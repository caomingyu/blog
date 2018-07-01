<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        $("li.Disable a").click(function () {
            return false;
        });
    });
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav>
    <ul class="pagination">
        <li style="display: inline-block;" <c:if test="${!page.hasPrevious}">class="Disable" </c:if>><a
                href="?start=0${page.params}"><span class="glyphicon glyphicon-chevron-left"></span><span
                class="glyphicon glyphicon-chevron-left"></span></a></li>
        <li style="display: inline-block" <c:if test="${!page.hasPrevious}">class="Disable"</c:if>><a
                href="?start=${page.start-page.count}${page.params}"><span
                class="glyphicon glyphicon-chevron-left"></span></a></li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="st">
            <c:if test="${st.count*page.count-page.start<=15 && st.count*page.count-page.start>=-5}">
                <li style="display: inline-block"><a href="?start=${st.index*page.count}${page.params}"><span
                        <c:if test="${st.index*page.count==page.start}">style="color: #0f0f0f;font-weight: bolder" </c:if>>${st.count}</span></a>
                </li>
            </c:if>
        </c:forEach>
        <li style="display: inline-block" <c:if test="${!page.hasNext}">class="Disable"</c:if>><a
                href="?start=${page.start+page.count}${page.params}"><span
                class="glyphicon glyphicon-chevron-right"></span></a></li>
        <li style="display: inline-block" <c:if test="${!page.hasNext}">class="Disable"</c:if>><a
                href="?start=${page.last}${page.params}"><span class="glyphicon glyphicon-chevron-right"></span><span
                class="glyphicon glyphicon-chevron-right"></span></a></li>
    </ul>
</nav>
</body>
</html>
