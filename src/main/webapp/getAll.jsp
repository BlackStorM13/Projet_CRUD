<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste de tous les client</title>
</head>
<body>
<h1>Liste des clients</h1>
<table>
    <c:forEach var = "client" items = "${listClient}">
        <tr>
            <td>${client.id}</td>
            <td>${client.nom}</td>
            <td>${client.prenom}</td>
            <td>${client.tel}</td>
            <td>${client.nom}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
