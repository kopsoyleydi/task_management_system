package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.Permissions;

import java.util.List;

public interface PermissionsRepoInter {

    List<Permissions> getPermissionById(Long id);

    List<Permissions> getAllPermissions();

    Permissions addPermission(Permissions permissions);
}
