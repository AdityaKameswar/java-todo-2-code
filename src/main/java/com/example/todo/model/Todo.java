// Write your code here

package com.example.todo.model;

import java.util.*;

public class Todo {
    private int id;
    private String todo;
    private String priority;
    private String status;
    public static HashSet<String> priorities = new HashSet<>(Arrays.asList("HIGH", "MEDIUM", "LOW"));
    public static HashSet<String> statuses = new HashSet<>(Arrays.asList("TO DO", "IN PROGRESS", "DONE"));

    public Todo(int id, String todo, String status, String priority) {
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public void printTodo() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + "\n id = " + this.id + "\n todo = " + this.todo
                + "\n priority = " + this.priority
                + "\n status = " + this.status + "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    public int getId() {
        return this.id;
    }

    public String getTodo() {
        return this.todo;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}