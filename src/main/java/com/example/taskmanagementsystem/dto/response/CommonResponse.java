package com.example.taskmanagementsystem.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {
    private String message;
    private Object data;
    private HttpStatus status;
}
