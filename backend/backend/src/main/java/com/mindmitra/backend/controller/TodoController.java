package com.mindmitra.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Todo;
import com.mindmitra.backend.service.TodoService;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService service;

    // SAVE TASK

    @PostMapping("/save")
    public String saveTask(@RequestBody Map<String, String> body){

        Todo todo = new Todo();

        todo.setTitle(body.get("title"));
        todo.setCategory(body.get("category"));
        todo.setSubtask(body.get("subtask"));
        todo.setPriority(body.get("priority"));

        todo.setCompleted(
            Boolean.parseBoolean(body.get("completed"))
        );

        todo.setDate(
            LocalDate.parse(body.get("date"))
        );

        Long userId =
            Long.parseLong(body.get("userId"));

        return service.saveTask(todo, userId);

    }

    // GET ALL TASKS OF USER

    @GetMapping("/user/{userId}")
    public List<Todo> getUserTasks(@PathVariable Long userId){

        return service.getUserTasks(userId);

    }

    // GET TASKS BY DATE

    @GetMapping("/user/{userId}/{date}")
    public List<Todo> getTasksByDate(
            @PathVariable Long userId,
            @PathVariable LocalDate date){

        return service.getTasksByDate(userId, date);

    }

    // MARK TASK COMPLETED

    @PutMapping("/complete/{taskId}")
    public String markCompleted(@PathVariable Long taskId){

        return service.markCompleted(taskId);

    }

}