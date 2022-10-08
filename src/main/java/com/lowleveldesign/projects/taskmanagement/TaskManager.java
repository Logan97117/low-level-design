package com.lowleveldesign.projects.taskmanagement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {
    private AtomicInteger tasksExecuted = new AtomicInteger(0);
    private ConcurrentHashMap<String,Task> tasks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Runnable> taskRunnables = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Integer> numDependenciesExecuted = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<String>> reverseDependencies = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    private void addVertex(String taskId) {
        this.tasks.putIfAbsent(taskId, new Task(taskId));
        this.taskRunnables.putIfAbsent(taskId, () -> {
            try {
                Thread.sleep(2000);
                this.tasks.get(taskId).complete();
                taskCompleted(taskId);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.numDependenciesExecuted.putIfAbsent(taskId, 0);
    }

    private void addEdge(String taskId, String dependentTaskId) {
        this.tasks.get(taskId).addDependency(this.tasks.get(dependentTaskId));
        this.reverseDependencies.putIfAbsent(dependentTaskId, new ArrayList<>());
        this.reverseDependencies.get(dependentTaskId).add(taskId);
    }

    public void addTask(String taskId, String dependentTaskId) {
        this.addVertex(taskId);
        this.addVertex(dependentTaskId);
        this.addEdge(taskId, dependentTaskId);
    }

    private void taskCompleted(String taskId) {
        this.tasksExecuted.incrementAndGet();
        System.out.println("Tasks done: " + this.tasksExecuted.get() + " out of " + this.tasks.size() + ", time taken " + System.currentTimeMillis()/1000);

        if(this.tasksExecuted.get() == this.tasks.size()) {
            System.out.println("All tasks completed");
            executorService.shutdown();
            return;
        }

        this.reverseDependencies.get(taskId).forEach((nextTaskId) -> {
            this.numDependenciesExecuted.computeIfPresent(nextTaskId, (__, val) -> val+1);
            if(this.numDependenciesExecuted.get(nextTaskId) == this.tasks.get(nextTaskId).getDependencies().size()) {
                executorService.submit(this.taskRunnables.get(nextTaskId));
            }
        });


    }

    public void startExecution() {
        this.tasks.forEach((taskId, task) -> {
            if(task.getDependencies().size() == 0)
                executorService.submit(this.taskRunnables.get(taskId));
        });
    }
}
