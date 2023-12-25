package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.TaskImpl;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.mapper.TaskMapper;
import com.example.taskmanagementsystem.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskImpl task;

    private final TaskMapper taskMapper;

    public CommonResponse addNewTask(TaskDto taskDto){
        try {
            return CommonResponse.builder()
                    .message("Task added success")
                    .data(taskMapper.toDto(task.addTask(taskMapper.toModel(taskDto))))
                    .status(HttpStatus.CREATED)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Something went wrong")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }
    }

    public CommonResponse changeTask(TaskDto taskDto){
        try {
            return CommonResponse.builder()
                    .data(taskMapper.toDto(task.changeTask(taskMapper.toModel(taskDto))))
                    .message("Task changed success")
                    .status(HttpStatus.CREATED)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Something went wrong")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }
    }

    public Page<Task> getAllTaskByUserEmail(String email, int size){
        return task.getAllTasksByUserEmail(email, size);
    }

    public CommonResponse deleteTaskById(Long id){
        try {
            task.deleteTaskById(id);
            return CommonResponse.builder()
                    .message("Success")
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Была проблема при удалении")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }

    }
}
