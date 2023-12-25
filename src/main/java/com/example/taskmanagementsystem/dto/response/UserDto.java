package com.example.taskmanagementsystem.dto.response;


import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany
    private List<PermissionDto> permissions;
}
