<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/book/check">
        <%
                out.print("用户名：<input type=\"text\" name=\"username\" value=\"\"><br>");
                out.print("密码： <input type=\"password\" name=\"password\"><br>");

        %>
        <input type="submit" value="登录"><br>
        ${error}
    </form>

</body>
</html>
