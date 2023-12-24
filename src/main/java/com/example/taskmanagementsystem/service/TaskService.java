package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.TaskImpl;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskImpl task;

    private final TaskMapper taskMapper;

    public TaskDto addNewTask(TaskDto taskDto){
        return taskMapper.toDto(task.addTask(taskMapper.toModel(taskDto)));
    }

    public TaskDto changeTask(TaskDto taskDto){
        return taskMapper.toDto(task.changeTask(taskMapper.toModel(taskDto)));
    }

    public List<TaskDto> getAllTaskByUserEmail(String email){
        return taskMapper.toDtoList(task.getAllTasksByUserEmail(email));
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
