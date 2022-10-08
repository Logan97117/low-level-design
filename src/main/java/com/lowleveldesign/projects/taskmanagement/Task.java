package com.lowleveldesign.projects.taskmanagement;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskId;
    private List<Task> dependencies;
    public Task(String taskId) {
        this.taskId = taskId;
        this.dependencies = new ArrayList<>();

    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<Task> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Task> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(Task task) {
        this.dependencies.add(task);
    }

    public void complete() {
        System.out.println("Task with task ID: " + this.taskId + " completed by " + Thread.currentThread().getName());
    }
}
