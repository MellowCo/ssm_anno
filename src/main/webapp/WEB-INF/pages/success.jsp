<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<h>执行成功</h>
<br>

user列表
<c:forEach var="user" items="${list}">
    id:${user.id}<br>
    name:${user.name}<br>
    sex:${user.sex}
</c:forEach>

${msg}

</body>
</html>
