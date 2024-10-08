/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoH2Service;

@RestController
public class TodoController {

    @Autowired
    public TodoH2Service todoService;

    @GetMapping("/todos")
    ArrayList<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/todos/{id}")
    Todo getById(@PathVariable("id") int id) {
        return todoService.getById(id);
    }

    @PostMapping("/todos")
    Todo postTodo(@RequestBody Todo todo) {
        return todoService.postTodo(todo);
    }

    @PutMapping("/todos/{id}")
    Todo putTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoService.putTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    void deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
    }
}
