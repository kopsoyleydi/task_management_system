package com.example.taskmanagementsystem.models;


import com.example.taskmanagementsystem.models.enums.TaskPriority;
import com.example.taskmanagementsystem.models.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task extends BaseModel{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @ManyToOne
    private User author;

    @ManyToMany
    private List<User> performers;


}
