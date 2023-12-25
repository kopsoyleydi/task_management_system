package com.example.taskmanagementsystem.dto.response;



import com.example.taskmanagementsystem.utils.LocalDateTimeConverter;
import jakarta.persistence.Convert;
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
    private TaskDto task;

    @ManyToOne
    private UserDto user;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;
}
