package com.geekbrains.controller;

import com.geekbrains.entity.Task;
import com.geekbrains.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String taskList(Model model) {
        Iterable<Task> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/add")
    public String addTask(Model model) {
        return "add-task";
    }

    @PostMapping("/tasks/add")
    public String addTaskPost(@RequestParam Integer priority, @RequestParam String description, @RequestParam Date date, Model model) {
        Task task = new Task(priority, description, date);
        taskService.addNewTask(task);
        return "redirect:/tasks";
    }
}
