<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script src="js/jquery-1.12.4.min.js"></script>

<script>
    $(function () {
        $("#btn").click(function () {
            alert("点击成功");
        });
    });
</script>

<body>

<form action="${pageContext.request.contextPath}/user/fileUpload" method="post" enctype="multipart/form-data">
    name:<input type="text" name="name"/>
    <br>
    file:<input type="file" name="file"/>
    <input type="submit" value="上传">
</form>

<form action="${pageContext.request.contextPath}/user/add" method="post">
    name:<input type="text" name="name"/><br>
    sex :<input type="text" name="sex"/><br>
    <input type="submit" value="提交"/><br>
</form>

<br>
<button id="btn">按钮</button>

<%--<img src="images/438211.jpg"><br>--%>

<br>

<h1>数据校验 testValidated</h1><br>
<form action="${pageContext.request.contextPath}/user/testValidated" method="post">
    name:<input type="text" name="name"/><br>
    sex :<input type="text" name="sex"/><br>
    <input type="submit" value="提交"/><br>
</form>
<br>


<h1>数据校验 testValid</h1><br>
<form action="${pageContext.request.contextPath}/user/testValid" method="post">
    name:<input type="text" name="name"/><br>
    sex :<input type="text" name="sex"/><br>
    <input type="submit" value="提交"/><br>
</form>
<br>

<a href="user/testInterceptor1">testInterceptor1</a><br>
<a href="user/testInterceptor2">testInterceptor2</a><br>

</body>
</html>
