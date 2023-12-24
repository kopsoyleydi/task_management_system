package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.TaskImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskImpl task;
}
