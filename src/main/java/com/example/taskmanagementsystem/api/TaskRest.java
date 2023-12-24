package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/task")
public class TaskRest {

    private final TaskService taskService;

    @PostMapping(value = "/addTask")
    public CommonResponse addNewTask(@RequestBody TaskDto taskDto){
        try {
            return CommonResponse.builder()
                    .data(taskService.addNewTask(taskDto))
                    .message("Task added success")
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

    @PutMapping(value = "/updateTask")
    public CommonResponse updateTask(@RequestBody TaskDto taskDto){
        try {
            return CommonResponse.builder()
                    .data(taskService.changeTask(taskDto))
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
}
