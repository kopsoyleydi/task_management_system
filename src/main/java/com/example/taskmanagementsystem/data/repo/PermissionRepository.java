package com.example.taskmanagementsystem.data.repo;

import com.example.taskmanagementsystem.models.Permissions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permissions, Long> {
}
