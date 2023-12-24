package com.example.taskmanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationUserDto {

    private String email;

    private String name;

    private String password;

    private String confirmPassword;

    private String phoneNumber;
}
