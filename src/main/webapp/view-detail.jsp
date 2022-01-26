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
<h1>City</h1>
<p>Id: ${city.getId()}</p>
<p>Name: ${city.getName()}</p>
<p>Popular: ${city.getPopular()}</p>
<p>Area: ${city.getArea()}</p>
<p>GDP: ${city.getGDP()}</p>
<p>Country: ${city.getCountry()}</p>
</body>
</html>
