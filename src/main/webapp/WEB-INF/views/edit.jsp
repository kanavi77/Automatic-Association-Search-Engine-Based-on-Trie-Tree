<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加语义库</title>
</head>
<body>
　<form action="add" method="post">

    <table width="400" align="center">
        <caption>添加语义库</caption>
        <tr>
            <th width="100" align="right">值</th>
            <td>
                <input name="value" value="${books.value}"/>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <th width="100" align="right">作者：</th>--%>
<%--            <td>--%>
<%--                <input name="author"  value="${books.author}" />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th width="100" align="right">价格：</th>--%>
<%--            <td>--%>
<%--                <input name="price" value="${books.price}"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th width="100" align="right">出版商：</th>--%>
<%--            <td>--%>
<%--                <input name="press" value="${books.press}"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">保存</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
