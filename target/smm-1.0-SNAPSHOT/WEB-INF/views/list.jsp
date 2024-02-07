<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>语义库</title>
</head>
<body>
<h3 align="center">
    <a href="edit">添加</a>
    <a href="sear">前缀搜索</a>
<%--    <a href="show">Trie树可视化</a>--%>
</h3>
<table width="400" align="center" border="1">
    <caption>语义库</caption>
    <thead>
    <tr>
        <th>id</th>
        <th>值</th>
        <th>查询次数</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.value}</td>
            <td>${book.count}</td>
            <td>
                <a href="delete?id=${book.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
