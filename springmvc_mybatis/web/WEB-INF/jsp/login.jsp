<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>系统登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名称：<input type="text" name="userName" /></br>
        密码：<input type="password" name="password" /></br>
        <input type="submit" value="登录" />
    </form>
</body>
</html>