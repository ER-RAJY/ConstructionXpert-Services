<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Projects</title>
</head>
<body>
<h1>List of Projects</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Budget</th>
    </tr>
    <c:forEach var="projet" items="${projets}">
        <tr>
            <td>${projet.id}</td>
            <td>${projet.nom}</td>
            <td>${projet.description}</td>
            <td>${projet.dateDebut}</td>
            <td>${projet.dateFin}</td>
            <td>${projet.budget}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
