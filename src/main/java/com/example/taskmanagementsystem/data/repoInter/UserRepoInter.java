package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepoInter {

    User getUserById(Long id);
    User addUser(User user);
    List<User> getAllUsers();

    User updateParam(User user);

    User getUserByEmail(String email);

    Page<User> getAllUsers(Pageable pageable);
}
