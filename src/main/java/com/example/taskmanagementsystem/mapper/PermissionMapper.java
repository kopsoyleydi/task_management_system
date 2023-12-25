package com.example.taskmanagementsystem.mapper;

import com.example.taskmanagementsystem.dto.response.PermissionDto;
import com.example.taskmanagementsystem.models.Permissions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionMapper {

    public PermissionDto toDto(Permissions permissions) {
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setId(permissions.getId());
        permissionDto.setRole(permissions.getRole());
        return permissionDto;
    }

    public Permissions toModel(PermissionDto permissionDto) {
        Permissions permissions = new Permissions();
        permissions.setId(permissionDto.getId());
        permissions.setRole(permissionDto.getRole());
        return permissions;
    }

    public List<PermissionDto> toDtoList(List<Permissions> permissionsList) {
        return permissionsList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Permissions> toModelList(List<PermissionDto> permissionDtoList) {
        return permissionDtoList.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
