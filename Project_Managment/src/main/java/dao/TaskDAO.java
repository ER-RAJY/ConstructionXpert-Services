package dao;

import db.DbConnect;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection connection;

    public TaskDAO() {
        this.connection = DbConnect.getConnection();
    }

    public void addTask(Task task) throws SQLException {
        String query = "INSERT INTO tasks (project_id, description, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, task.getProjectId());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, services.DateCasting.ToSqlDate(task.getStartDate()));
            stmt.setDate(4, services.DateCasting.ToSqlDate(task.getEndDate()));
            stmt.setString(5, task.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks ";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setProjectId(rs.getInt("project_id"));
                task.setDescription(rs.getString("description"));
                task.setStartDate(rs.getDate("start_date"));
                task.setEndDate(rs.getDate("end_date"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> getAllTasks(int projectId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks WHERE project_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, projectId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setId(rs.getInt("id"));
                    task.setProjectId(rs.getInt("project_id"));
                    task.setDescription(rs.getString("description"));
                    task.setStartDate(rs.getDate("start_date"));
                    task.setEndDate(rs.getDate("end_date"));
                    task.setStatus(rs.getString("status"));
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }

    public Task getTaskById(int taskId) throws SQLException {
        Task task = null;
        String query = "SELECT * FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, taskId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    task = new Task();
                    task.setId(rs.getInt("id"));
                    task.setProjectId(rs.getInt("project_id"));
                    task.setDescription(rs.getString("description"));
                    task.setStartDate(rs.getDate("start_date"));
                    task.setEndDate(rs.getDate("end_date"));
                    task.setStatus(rs.getString("status"));
                }
            }
        }
        return task;
    }

    public void updateTask(Task task) throws SQLException {
        String query = "UPDATE tasks SET project_id = ?, description = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, task.getProjectId());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, services.DateCasting.ToSqlDate(task.getStartDate()));
            stmt.setDate(4, services.DateCasting.ToSqlDate(task.getEndDate()));
            stmt.setString(5, task.getStatus());
            stmt.setInt(6, task.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTask(int taskId) throws SQLException {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, taskId);
            stmt.executeUpdate();
        }
    }
}
