package com.example.taskmanagementsystem.data.repoInter.impl;

import com.example.taskmanagementsystem.data.repo.UserRepository;
import com.example.taskmanagementsystem.data.repoInter.UserRepoInter;
import com.example.taskmanagementsystem.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserRepoInter {

    private final UserRepository userRepository;
    @Override
    public User getUserById(Long id) {
        return userRepository.findAllById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateParam(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
