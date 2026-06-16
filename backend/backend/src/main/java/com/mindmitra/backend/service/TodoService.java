package com.mindmitra.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Todo;
import com.mindmitra.backend.entity.User;
import com.mindmitra.backend.repository.TodoRepository;
import com.mindmitra.backend.repository.UserRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    @Autowired
    private UserRepository userRepo;

    // SAVE TASK

    public String saveTask(Todo todo, Long userId){

        User user = userRepo.findById(userId).orElse(null);

        todo.setUser(user);

        todoRepo.save(todo);

        return "Task Saved Successfully";

    }

    // GET USER TASKS

    public List<Todo> getUserTasks(Long userId){

        return todoRepo.findByUser_Id(userId);

    }

    // GET TASKS BY DATE

    public List<Todo> getTasksByDate(Long userId, LocalDate date){

        return todoRepo.findByUser_IdAndDate(userId, date);

    }

    // MARK TASK COMPLETED

    public String markCompleted(Long taskId){

        Todo todo = todoRepo.findById(taskId).orElse(null);

        if(todo != null){

            todo.setCompleted(true);

            todoRepo.save(todo);

            return "Task Completed";

        }

        return "Task Not Found";

    }

}