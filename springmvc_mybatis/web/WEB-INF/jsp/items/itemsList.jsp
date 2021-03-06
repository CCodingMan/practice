<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function deleteItems() {
            document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";
            document.itemsForm.submit();
        }

        function queryItems() {
            document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
当前用户：${userName}
<c:if test="${userName!=null}">
    <a href="${pageContext.request.contextPath}/logout.action">退出</a>
</c:if>
<form name="itemsForm" method="post">
    查询条件：
    <table width="100%" border="1">
        <tr>
            <td>
                商品名称：<input type="text" name="itemsCustom.name">
                商品类型：
                <select name="itemtypes">
                    <c:forEach items="${itemtypes}" var="itemtype">
                        <option value="${itemtype.key}">${itemtype.value}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="button" value="查询" onclick="queryItems()">
                <input type="button" value="批量删除" onclick="deleteItems()">
            </td>
        </tr>
    </table>

    商品列表：
    <table width="100%" border="1">
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList}" var="item">
            <tr>
                <td><input type="checkbox" name="items_id" value="${item.id}"></td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>${item.detail}</td>
                <td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
