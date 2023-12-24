package com.example.taskmanagementsystem.data.repoInter.impl;


import com.example.taskmanagementsystem.data.repo.TaskRepository;
import com.example.taskmanagementsystem.data.repoInter.TaskRepoInter;
import com.example.taskmanagementsystem.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskImpl implements TaskRepoInter{

    private final TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task changeTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasksByUserEmail(String userEmail) {
        return taskRepository.getTasksByUser(userEmail);
    }
}
