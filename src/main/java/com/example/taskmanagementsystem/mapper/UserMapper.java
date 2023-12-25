package com.example.taskmanagementsystem.mapper;


import com.example.taskmanagementsystem.dto.response.UserDto;
import com.example.taskmanagementsystem.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PermissionMapper permissionMapper;

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPermissions(permissionMapper.toDtoList(user.getPermissions()));
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPermissions(permissionMapper.toModelList(userDto.getPermissions()));
        return user;
    }

    public List<UserDto> toUserDtoList(List<User> userList) {
        return userList.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public List<User> toUserList(List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(this::toUser)
                .collect(Collectors.toList());
    }

}
