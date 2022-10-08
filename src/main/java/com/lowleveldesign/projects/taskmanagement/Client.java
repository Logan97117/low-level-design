package com.lowleveldesign.projects.taskmanagement;

public class Client {
    public static void main(String args[])throws Exception {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("5", "8");
        taskManager.addTask("5", "7");
        taskManager.addTask("6", "7");
        taskManager.addTask("3", "6");
        taskManager.addTask("4", "6");
        taskManager.addTask("1", "5");
        taskManager.addTask("2", "5");
        taskManager.addTask("3", "5");
        taskManager.addTask("1", "4");
        taskManager.startExecution();
    }
}
