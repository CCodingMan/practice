<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/queryItems.action" method="post">
    查询条件：
    <table width="100%" border="1">
        <tr>
            <td><input type="submit" value="查询"></td>
        </tr>
    </table>
</form>
商品列表：
<table width="100%" border="1">
    <tr>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>生产日期</td>
        <td>商品描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy_MM-dd HH:mm:ss"/> </td>
            <td>${item.detail}</td>
            <td><a href="${pageContext.request.contextPath}/editItems.action?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
