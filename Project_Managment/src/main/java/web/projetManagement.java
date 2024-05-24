package web;

import dao.ProjectDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Project;
import services.DateCasting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Project")
public class projetManagement extends HttpServlet {


    private ProjectDAO projectDao;
    Project project;
    List projects = null;


    public void init(ServletConfig sc) throws ServletException {
        try {
            projectDao = new ProjectDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double budget = Double.parseDouble(request.getParameter("budget"));

        switch (action) {
            case "AddProject":
                try {
                    project = new Project(name, description, DateCasting.convertStringToDate(startDate, "yyyy-MM-dd"), DateCasting.convertStringToDate(startDate, "yyyy-MM-dd"), budget);
                    projectDao.addProject(project);
                    response.sendRedirect("EntrerP");

                } catch (SQLException se) {
                    System.out.println(se.getMessage());
                }
                break;

            case "AddToUpdate":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    project = new Project(id, name, description, DateCasting.convertStringToDate(startDate, "yyyy-MM-dd"), DateCasting.convertStringToDate(startDate, "yyyy-MM-dd"), budget);
                    projectDao.updateProject(project);
                    response.sendRedirect("EntrerP");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }

    }








    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        int id = Integer.parseInt(request.getParameter("TheProjectId"));
        String action = request.getParameter("action");

        switch (action)
        {
            case "delete":
                try {
                    projectDao.deleteProject(id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                RequestDispatcher SHOWAFTER = request.getRequestDispatcher("projects.jsp");
                try {
                    request.setAttribute("projects", projectDao.getAllProjects());
                    SHOWAFTER.forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "update":
                try {
                    request.getServletContext().setAttribute("showUpdateproject", projectDao.getProjectById(id));
                    response.sendRedirect("UpdateProjectForm.jsp?id=" + id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }




    }












}
