package dao;

import db.DbConnect;
import model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private Connection connection;

    public ProjectDAO() {
        this.connection = DbConnect.getConnection();
    }

    public void addProject(Project project) throws SQLException {
        String query = "INSERT INTO projects (name, description, start_date, end_date, budget) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setDate(3,services.DateCasting.ToSqlDate(project.getStartDate()));
            stmt.setDate(4,services.DateCasting.ToSqlDate(project.getEndDate()));
            stmt.setDouble(5, project.getBudget());
            stmt.executeUpdate();
        }
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM projects";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("start_date"));
                project.setEndDate(rs.getDate("end_date"));
                project.setBudget(rs.getDouble("budget"));
                projects.add(project);
            }
        }
        return projects;
    }

    public Project getProjectById(int projectId) throws SQLException {
        Project project = null;
        String query = "SELECT * FROM projects WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, projectId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    project = new Project();
                    project.setId(rs.getInt("id"));
                    project.setName(rs.getString("name"));
                    project.setDescription(rs.getString("description"));
                    project.setStartDate(rs.getDate("start_date"));
                    project.setEndDate(rs.getDate("end_date"));
                    project.setBudget(rs.getDouble("budget"));
                }
            }
        }
        return project;
    }

    public void updateProject(Project project) throws SQLException {
        String query = "UPDATE projects SET name = ?, description = ?, start_date = ?, end_date = ?, budget = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setDate(3, services.DateCasting.ToSqlDate(project.getStartDate()));
            stmt.setDate(4, services.DateCasting.ToSqlDate(project.getEndDate()));
            stmt.setDouble(5, project.getBudget());
            stmt.setInt(6, project.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteProject(int projectId) throws SQLException {
        String query = "DELETE FROM projects WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, projectId);
            stmt.executeUpdate();
        }
    }








}
