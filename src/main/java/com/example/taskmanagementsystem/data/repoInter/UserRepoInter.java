package com.example.taskmanagementsystem.data.repoInter;

import com.example.taskmanagementsystem.models.User;

import java.util.List;

public interface UserRepoInter {

    User getUserById(Long id);
    User addUser(User user);
    List<User> getAllUsers();

    User updateParam(User user);

    User getUserByEmail(String email);
}
