package com.example.taskmanagementsystem.data.repoInter.impl;

import com.example.taskmanagementsystem.data.repo.PermissionRepository;
import com.example.taskmanagementsystem.data.repoInter.PermissionsRepoInter;
import com.example.taskmanagementsystem.models.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionsImpl implements PermissionsRepoInter {

    private final PermissionRepository permissionRepository;

    @Override
    public List<Permissions> getPermissionById(Long id) {
        return permissionRepository.findAllById(id);
    }

    @Override
    public List<Permissions> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permissions getPermissionByRole(String role){
        return permissionRepository.findByRole(role);
    }
}
