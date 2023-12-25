package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final UserMapper userMapper;

    public TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());
        taskDto.setAuthor(userMapper.toUserDto(task.getAuthor()));
        taskDto.setPerformers(userMapper.toUserDtoList(task.getPerformers()));
        return taskDto;
    }

    public Task toTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        task.setAuthor(userMapper.toUser(taskDto.getAuthor()));
        task.setPerformers(userMapper.toUserList(taskDto.getPerformers()));
        return task;
    }

    public List<TaskDto> toTaskDtoList(List<Task> taskList) {
        return taskList.stream()
                .map(this::toTaskDto)
                .collect(Collectors.toList());
    }

    public List<Task> toTaskList(List<TaskDto> taskDtoList) {
        return taskDtoList.stream()
                .map(this::toTask)
                .collect(Collectors.toList());
    }
}
