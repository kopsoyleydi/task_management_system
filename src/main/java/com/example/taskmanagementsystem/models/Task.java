package com.example.taskmanagementsystem.models;


import com.example.taskmanagementsystem.models.enums.TaskPriority;
import com.example.taskmanagementsystem.models.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @JoinColumn(name = "task_id")
    @OneToMany
    private List<Comment> comment;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<User> performers;


}
