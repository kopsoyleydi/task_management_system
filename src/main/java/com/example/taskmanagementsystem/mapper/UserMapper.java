package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.response.UserDto;
import com.example.taskmanagementsystem.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(UserDto userDto);

    List<UserDto> toDtoList(List<User> list);

    List<User> toModelList(List<UserDto> list);
}
