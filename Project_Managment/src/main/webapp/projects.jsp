<%--
  Created by IntelliJ IDEA.
  User: nourdine
  Date: 5/24/2024
  Time: 11:30 AM
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
    <!-- My CSS -->
    <link rel="stylesheet" href="style.css">

    <title>ConstructionXpert</title>
</head>
<body>


<!-- SIDEBAR -->
<section id="sidebar">
    <a href="dashboard.html" class="brand">
        <i class='bx bxs-smile'></i
        >
        <span class="text">ConstructionXpert</span>
    </a>
    <ul class="side-menu top">
        <li class="active">
            <a href="dashboard.html">
                <i class='bx bxs-dashboard' ></i>
                <span class="text">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="projects.html">
                <i class='bx bxs-shopping-bag-alt' ></i>
                <span class="text">Projects</span>
            </a>
        </li>
        <li>
            <a href="taches.html">
                <i class='bx bxs-doughnut-chart' ></i>
                <span class="text">Tasks</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bxs-message-dots' ></i>
                <span class="text">Resource</span>
            </a>
        </li>

    </ul>
    <ul class="side-menu">

        <li class="logout">
            <a href="#" class="logout">
                <i class='bx bxs-log-out-circle' ></i>
                <span class="text">Logout</span>
            </a>
        </li>
    </ul>
</section>
<!-- SIDEBAR -->



<!-- CONTENT -->
<section id="content">
    <!-- NAVBAR -->
    <nav>
        <i class='bx bx-menu' ></i>
        <a href="#" class="nav-link">Categories</a>
        <form action="#">
            <div class="form-input">
                <input type="search" placeholder="Search...">
                <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
            </div>
        </form>
        <input type="checkbox" id="switch-mode" hidden>
        <label for="switch-mode" class="switch-mode"></label>

        <a href="#" class="profile">
            <img src="img/people.png">
        </a>
    </nav>
    <!-- NAVBAR -->

    <!-- MAIN -->
    <main>
        <div class="head-title">
            <div class="left">
                <a href="#" class="btn-download" style="background-color: #267449;">
                    <i class='bx bxs-cloud-download' ></i>
                    <span class="text">Download EXCEL</span>
                </a>
            </div>

        </div>




        <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Recent Orders</h3>
                    <div class="head-title">
                        <div class="left">
                            <a href="AddProject.jsp" class="btn-download">
                                <i class='bx bx-plus'></i>
                                <span class="text"> add new </span>
                            </a>
                        </div>
                    </div>
                </div>
                <table>
                    <thead>
                    <tr>
                        <th>Projects</th>
                        <th>description</th>
                        <th>Date Order</th>
                        <th>End Date</th>
                        <th >budget</th>
                        <th >Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${projects}" var="project">
                    <tr>
                        <td>
                            <p>  <c:out value="${project.name}"/></p>
                        </td>
                        <td>  <c:out value="${project.description}"/> </td>
                        <td>  <c:out value="${project.startDate}"/></td>
                        <td>  <c:out value="${project.endDate}"/></td>
                        <td>  <c:out value="${project.budget}"/></td>
                        <td>
                            <div class="button-container" style="display: flex;gap: 10px;align-items: center;">
                            <form action="Project" method="get">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="TheProjectId" value="${project.id}">
                                <button class="button1">Update</button>
                            </form>
                            <form action="Project" method="get">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="TheProjectId" value="${project.id}">
                                <button class="button2">delete</button>
                            </form>
                                <form action="Project" method="get">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="TheProjectId" value="${project.id}">
                                    <button class="button3">Tasks</button>
                                </form>



                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </main>
    <!-- MAIN -->
</section>
<!-- CONTENT -->


<script src="script.js"></script>
</body>
</html>