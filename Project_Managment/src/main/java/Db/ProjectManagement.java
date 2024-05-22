package Db;

import Dao.ProjetDaoIMp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjectManagement {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/projectMnagment"; // Change the URL accordingly
        String username = "postgres"; // Change to your PostgreSQL username
        String password = "admin"; // Change to your PostgreSQL password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Now you can perform database operations using this connection
            ProjetDaoIMp projetDaoIMp = new ProjetDaoIMp(connection);

            // Your database operations go here

        } catch (SQLException e) {
            System.out.println("Connection to the PostgreSQL server failed. Error: " + e.getMessage());
        }
    }
}
