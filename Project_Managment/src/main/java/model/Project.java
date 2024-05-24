package model;

import java.util.Date;
import java.util.List;


public class Project {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private double budget;

    private List<Task> tasks;

    public Project() {
    }

    public Project(int id, String name, String description, Date startDate, Date endDate, double budget, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.tasks = tasks;
    }

    public Project(int id, String name, String description, Date startDate, Date endDate, double budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Project(String name, String description, Date startDate, Date endDate, double budget, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.tasks = tasks;
    }

    public Project(String name, String description, Date startDate, Date endDate, double budget) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
