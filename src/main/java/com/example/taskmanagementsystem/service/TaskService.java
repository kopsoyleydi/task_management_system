package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.TaskImpl;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.mapper.TaskMapper;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskImpl task;

    private final JwtTokenUtils jwtTokenUtils;

    private final TaskMapper taskMapper;

    public CommonResponse addNewTask(TaskDto taskDto){
        try {
            return CommonResponse.builder()
                    .message("Task added success")
                    .data(taskMapper.toTaskDto(task.addTask(taskMapper.toTask(taskDto))))
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

    public CommonResponse changeTask(TaskDto taskDto, String token){
        try {
            String email = taskDto.getAuthor().getEmail();
            String initEmail = jwtTokenUtils.extractUsername(extractToken(token));
            if(initEmail.equals(email)){
                return CommonResponse.builder()
                        .data(taskMapper.toTaskDto(task.changeTask(taskMapper.toTask(taskDto))))
                        .message("Task changed success")
                        .status(HttpStatus.CREATED)
                        .build();
            }
            else {
                return CommonResponse.builder()
                        .message("You dont change this task")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }

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

    public CommonResponse deleteTaskById(Long id, String token){
        String initEmail = jwtTokenUtils.extractUsername(extractToken(token));
        String email = task.getTaskById(id).getAuthor().getEmail();
        try {
            if(email.equals(initEmail)){
                task.deleteTaskById(id);
                return CommonResponse.builder()
                        .message("Success")
                        .build();
            }
            else {
                return CommonResponse.builder()
                        .message("You dont delete this task")
                        .build();
            }

        }
        catch (Exception e){
            return CommonResponse.builder()
                    .message("Была проблема при удалении")
                    .status(HttpStatus.NOT_MODIFIED)
                    .build();
        }

    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Убираем "Bearer " из строки
        }
        return null;
    }
}
