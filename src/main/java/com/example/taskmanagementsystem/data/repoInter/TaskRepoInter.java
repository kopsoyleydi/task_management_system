package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.Task;
import org.springframework.data.domain.Page;

public interface TaskRepoInter {

    Task addTask(Task task);

    Task changeTask(Task task);

    void deleteTaskById(Long id);

    Page<Task> getAllTasksByUserEmail(String userEmail, int size);

}
