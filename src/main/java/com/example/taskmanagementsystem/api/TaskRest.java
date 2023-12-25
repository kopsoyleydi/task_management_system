package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.request.PageTask;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public CommonResponse updateTask(@RequestBody TaskDto taskDto, @RequestHeader("Authorization") String token){
        return taskService.changeTask(taskDto, token);
    }

    @DeleteMapping("/delete/{taskId}")
    public CommonResponse deleteTaskById(@PathVariable Long taskId,  @RequestHeader("Authorization") String token){
        return taskService.deleteTaskById(taskId, token);
    }

    @GetMapping("/getTaskByUser")
    public Page<Task> getTasksByUser(@RequestBody PageTask pageTask){
        return taskService.getAllTaskByUserEmail(pageTask.getEmail(), pageTask.getSize());
    }
}
