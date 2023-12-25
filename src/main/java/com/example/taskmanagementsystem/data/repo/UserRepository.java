package com.example.taskmanagementsystem.data.repo;

import com.example.taskmanagementsystem.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);
    User findAllById(Long id);
}
