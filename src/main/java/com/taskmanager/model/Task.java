package com.taskmanager.model;

public class Task {

    private int id;
    private String title;
    private String description;
    private String status;
    private int userId;

    // Default constructor
    public Task() {}

    // Used when creating a new task
    public Task(String title, String description, String status, int userId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    // Getters & Setters
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public int getUserId() { 
        return userId; 
    }
    public void setUserId(int userId) { 
        this.userId = userId; 
    }
}
