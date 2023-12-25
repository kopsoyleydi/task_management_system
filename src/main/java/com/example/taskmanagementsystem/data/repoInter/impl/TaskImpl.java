package com.example.taskmanagementsystem.data.repoInter.impl;


import com.example.taskmanagementsystem.data.repo.TaskRepository;
import com.example.taskmanagementsystem.data.repoInter.TaskRepoInter;
import com.example.taskmanagementsystem.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Task> getAllTasksByUserEmail(String userEmail, int size) {
        Pageable pageable = Pageable.ofSize(size);
        return taskRepository.getTasksByUser(userEmail, pageable);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findAllById(id);
    }


}
