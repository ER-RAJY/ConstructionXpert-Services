package model;

import java.util.Date;
import java.util.List;


public class Task {
    private int id;
    private int projectId;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
    private List<Resource> resources;

    public Task() {
    }

    public Task(int projectId, String description, Date startDate, Date endDate, String status, List<Resource> resources) {
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.resources = resources;
    }

    public Task(int id, int projectId, String description, Date startDate, Date endDate, String status, List<Resource> resources) {
        this.id = id;
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.resources = resources;
    }

    public Task(int projectId, String description, Date startDate, Date endDate, String status) {
        this.projectId = projectId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Task(String description, Date startDate, Date endDate, String status) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}