package com.example.taskmanagementsystem.mapper;


import com.example.taskmanagementsystem.dto.response.PermissionDto;
import com.example.taskmanagementsystem.models.Permissions;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionDto toDto(Permissions permissions);

    Permissions toModel(PermissionDto permissionDto);

    List<PermissionDto> toDtoList(List<Permissions> list);

    List<Permissions> toModelList(List<PermissionDto> list);
}
