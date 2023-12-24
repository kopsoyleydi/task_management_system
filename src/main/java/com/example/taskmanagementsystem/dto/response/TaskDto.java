package com.example.taskmanagementsystem.dto.response;


import com.example.taskmanagementsystem.models.Comment;
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

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @JoinColumn(name = "task_id")
    @OneToMany
    private List<CommentDto> comment;

    @ManyToOne
    private UserDto author;

    @ManyToMany
    private List<UserDto> performers;
}
