package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.Task;

import java.util.List;

public interface TaskRepoInter {

    Task addTask(Task task);

    Task changeTask(Task task);

    void deleteTaskById(Long id);

    List<Task> getAllTasksByUserEmail(String userEmail);

}
