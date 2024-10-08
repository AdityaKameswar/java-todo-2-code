/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoH2Service implements TodoRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Todo> getAll() {
        ArrayList<Todo> arr = new ArrayList<>(db.query("select * from todolist", new TodoRowMapper()));
        System.out.println("=====================================" + "\n Printing Array of size = " + arr.size()
                + "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for (Todo todo : arr)
            todo.printTodo();
        return arr;
    }

    @Override
    public Todo getById(int id) {
        try {
            Todo out = db.queryForObject("select * from todolist where id = ? ", new TodoRowMapper(), id);
            out.printTodo();
            return out;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo postTodo(Todo todo) {
        db.update("insert into todolist(todo, status, priority) values(?,?,?)", todo.getTodo(), todo.getStatus(),
                todo.getPriority());
        Todo out = db.queryForObject("select * from todolist where todo = ? and status = ? and priority = ? ",
                new TodoRowMapper(), todo.getTodo(), todo.getStatus(), todo.getPriority());
        out.printTodo();
        return out;
    }

    @Override
    public Todo putTodo(int id, Todo todo) {

        if (todo.getTodo() != null) {
            db.update("update todolist set todo = ? where id = ?", todo.getTodo(), id);
        }
        if (todo.getStatus() != null && Todo.statuses.contains(todo.getStatus())) {
            db.update("update todolist set status = ? where id = ?", todo.getStatus(), id);
        }
        if (todo.getPriority() != null && Todo.priorities.contains(todo.getPriority())) {
            db.update("update todolist set priority = ? where id = ?", todo.getPriority(), id);
        }
        Todo out = getById(id);
        out.printTodo();
        return out;
    }

    @Override
    public void deleteTodo(int id) {
        db.update("delete from todolist where id =?", id);
        System.out.println("deleted: " + id);
    }

}