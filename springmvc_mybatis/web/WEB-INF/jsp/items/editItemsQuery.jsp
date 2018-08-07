<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function editItemsAllSubmit() {
            document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsAllSubmit.action";
            document.itemsForm.submit();
        }

        function queryItems() {
            document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsQuery.action";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" method="post">
    查询条件：
    <table width="100%" border="1">
        <tr>
            <td>商品名称：<input type="text" name="itemsCustom.name"></td>
            <td>
                <input type="button" value="查询" onclick="queryItems()">
                <input type="button" value="批量修改提交" onclick="editItemsAllSubmit()">
            </td>
        </tr>
    </table>

    商品列表：
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
        </tr>
        <c:forEach items="${itemsList}" var="item" varStatus="status">
            <tr>
                <td>
                    <input type="text" name="itemList[${status.index}].name" value="${item.name}">
                    <input type="hidden" name="itemList[${status.index}].id" value="${item.id}">
                </td>
                <td>
                    <input type="text" name="itemList[${status.index}].price" value="${item.price}">
                </td>
                <td>
                    <input type="text" name="itemList[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
                </td>
                <td><input type="text" name="itemList[${status.index}].detail" value="${item.detail}"></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
