<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>错误信息</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:if test="${allErrors} != null">
    <c:forEach items="${allErrors }" var="error">
        ${error.defaultMessage}<br/>
    </c:forEach>
</c:if>

<c:if test="${message} != null">
    ${message}
</c:if>
</body>
</html>