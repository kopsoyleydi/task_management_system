package com.example.taskmanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageComment {

    private Long taskId;

    private int size;
}
