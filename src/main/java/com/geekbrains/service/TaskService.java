package com.geekbrains.service;

import com.geekbrains.entity.Task;
import com.geekbrains.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll(Sort.by(Sort.Order.asc("date"), Sort.Order.desc("priority")));
    }

    public Optional<Task> findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Task addNewTask(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
