<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        // 请求json输出,json
        function requestJson() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestJson.action',
                contentType:'application/json;charset=utf-8',
                //数据格式必须是json串
                data:'{"name":"手机","price":99}',
                success:function(data){
                    console.log(data);
                }
            })
        }

        //请求key/value,输出json
        function responseJson() {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/responseJson.action',
                //数据格式必须是json串
                data:'name=手机&price=99',
                success:function(data){
                    console.log(data);
                }
            })
        }
    </script>
</head>
<body>
    <input type="button" value="请求json输出,json" onclick="requestJson()"/>
    <input type="button" value="请求key/value,输出json" onclick="responseJson()"/>
</body>
</html>
