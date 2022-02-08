<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/26/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All City</h1>
<a href="/cities?action=creatGet">Create new city</a>
<c:if test="${requestScope['listCity'].isEmpty()}">
    <h2 style="color: red">Không có sản phẩm nào</h2>
</c:if>
<c:if test="${requestScope['check'] == true}">
    <h2 style="color: blue">Tạo sản phẩm thành công</h2>
</c:if>
<c:if test="${requestScope['listCity'].isEmpty() == false}">
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Popular</td>
            <td>Area</td>
            <td>GDP</td>
            <td>Country</td>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items="${listCity}" var="city">
            <tr>
                <td>${city.getId()}</td>
                <td><a id="name" style="text-decoration: none" href="/cities?action=detail&id=${city.getId()}">${city.getName()}</a></td>
                <td <c:if test="${city.getPopular() > 1000000}">
                    style="color: red" </c:if>>${city.getPopular()}</td>
                <td>${city.getArea()}</td>
                <td <c:if test="${city.getGDP() < 10000}">
                    style="color: red" </c:if>>${city.getGDP()}</td>
                <td>${city.getCountry()}</td>
                <td><a href="/cities?action=editGet&id=${city.getId()}">Edit</a></td>
                <td><a href="/cities?action=delete&id=${city.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
