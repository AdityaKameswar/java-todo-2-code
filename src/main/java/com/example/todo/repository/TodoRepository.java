// Write your code here
package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.Todo;

public interface TodoRepository {
    ArrayList<Todo> getAll();

    Todo getById(int id);

    Todo postTodo(Todo todo);

    Todo putTodo(int id, Todo todo);

    void deleteTodo(int id);
}