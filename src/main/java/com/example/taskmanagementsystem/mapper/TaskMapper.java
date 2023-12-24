package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.response.TaskDto;
import com.example.taskmanagementsystem.models.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toModel(TaskDto taskDto);

    List<TaskDto> toDtoList(List<Task> list);

    List<Task> toModelList(List<TaskDto> list);

}
