package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/task")
public class TaskRest {

    private final TaskService taskService;

    @PostMapping(value = "/addTask")
    public CommonResponse addNewTask(@RequestBody TaskDto taskDto){
        return taskService.addNewTask(taskDto);
    }

    @PutMapping(value = "/updateTask")
    public CommonResponse updateTask(@RequestBody TaskDto taskDto){
        return taskService.changeTask(taskDto);
    }

    @DeleteMapping("/delete/{taskId}")
    public CommonResponse deleteTaskById(@PathVariable Long taskId){
        return taskService.deleteTaskById(taskId);
    }
}
