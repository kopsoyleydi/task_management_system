package com.example.taskmanagementsystem.dto.response;


import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.models.User;
import com.example.taskmanagementsystem.utils.LocalDateTimeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {

    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;
}
