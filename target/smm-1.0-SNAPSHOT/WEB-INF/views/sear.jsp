<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询相关图书</title>
</head>
<body>
　<form action="/book/find" method="post">

    <table width="400" align="center">
        <caption>前缀搜索</caption>
        <tr>
            <th width="200" align="right">输入：</th>
            <td>
                <input name="bookname" value="${book.value}"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <button type="submit">查询</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
