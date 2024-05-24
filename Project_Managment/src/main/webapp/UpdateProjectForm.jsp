<%@ page import="dao.ProjectDAO" %>
<%@ page import="model.Project" %>
<%--
  Created by IntelliJ IDEA.
  User: Taoufik
  Date: 5/22/2024
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Boxicons -->
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <title>Add Project Form</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Poppins:wght@400;500;600;700&display=swap');

        :root {
            --poppins: 'Poppins', sans-serif;
            --lato: 'Lato', sans-serif;

            --light: #F9F9F9;
            --blue: #3C91E6;
            --light-blue: #CFE8FF;
            --grey: #eee;
            --dark-grey: #AAAAAA;
            --dark: #342E37;
            --red: #DB504A;
            --yellow: #FFCE26;
            --light-yellow: #FFF2C6;
            --orange: #FD7238;
            --light-orange: #FFE0D3;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: var(--lato), sans-serif;
            background-color: var(--light);
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: var(--blue);
            color: var(--dark);
            padding: 10px 0;
            text-align: center;

        }

        .navbar li,span,a {
            text-decoration: none;
            color: var(--dark);
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: var(--light);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: var(--dark);
            font-family: var(--poppins);
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: inline-block;
            width: 150px;
            font-weight: bold;
            color: var(--dark);
        }

        input[type="text"],
        input[type="date"],
        input[type="number"] {
            width: calc(100% - 170px);
            padding: 8px;
            border: 1px solid var(--grey);
            border-radius: 5px;
            box-sizing: border-box;
            font-family: var(--lato);
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: var(--blue);
            color: var(--light);
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-family: var(--poppins);
            font-weight: 600;
        }

        input[type="submit"]:hover {
            background-color: var(--light-blue);
        }

    </style>
</head>
<body>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProjectDAO projectDAO = new ProjectDAO();
    Project project = (Project) request.getServletContext().getAttribute("showUpdateproject");
%>

<div class="navbar">
    <a href="dashboard.html" class="brand">
        <i class='bx bxs-smile'></i>
        <span class="text">ConstructionXpert</span>
    </a>
</div>
<div class="container">
    <h2 style="text-align: center;">Update Project</h2>

    <form action="Project" method="POST">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="hidden" name="action" value="AddToUpdate">
            <input type="hidden" name="id" value="<%=project.getId()%>">
            <input type="text" id="name" name="name" required value="<%=project.getName()%>">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required value="<%=project.getDescription()%>">
        </div>
        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required value="<%=project.getStartDate()%>">
        </div>
        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required value="<%=project.getEndDate()%>">
        </div>
        <div class="form-group">
            <label for="budget">Budget:</label>
            <input type="number" id="budget" name="budget" step="0.01" required value="<%=project.getBudget()%>">
        </div>
        <div class="form-group">
            <input type="submit" value="Edit">
        </div>
    </form>
</div>
</body>
</html>
