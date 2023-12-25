package com.example.taskmanagementsystem.dto.response;



import com.example.taskmanagementsystem.models.User;
import com.example.taskmanagementsystem.models.enums.TaskPriority;
import com.example.taskmanagementsystem.models.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TaskDto {

    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    private TaskPriority priority;

    @ManyToOne
    private UserDto author;

    @ManyToMany
    private List<UserDto> performers;
}
