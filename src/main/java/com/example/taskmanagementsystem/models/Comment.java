package com.example.taskmanagementsystem.models;


import com.example.taskmanagementsystem.utils.LocalDateTimeConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment extends BaseModel{

    @Column(name = "message")
    private String message;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user_id;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;

}
