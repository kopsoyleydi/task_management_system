package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.PermissionsImpl;
import com.example.taskmanagementsystem.dto.response.PermissionDto;
import com.example.taskmanagementsystem.mapper.PermissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionsImpl permissions;

    private final PermissionMapper permissionMapper;

    public PermissionDto addNewPermission(PermissionDto permissionDto){
        return permissionMapper
                .toDto(permissions.addPermission(permissionMapper.toModel(permissionDto)));
    }

    public List<PermissionDto> getPermissionById(Long id){
        return permissionMapper
                .toDtoList(permissions.getPermissionById(id));
    }

    public List<PermissionDto> getAllPermission(){
        return permissionMapper.toDtoList(permissions.getAllPermissions());
    }
}
