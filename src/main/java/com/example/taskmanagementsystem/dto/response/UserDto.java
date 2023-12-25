package com.example.taskmanagementsystem.dto.response;


import com.example.taskmanagementsystem.models.Permissions;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permissions> permissions;
}
