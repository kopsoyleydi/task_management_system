package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.PermissionsImpl;
import com.example.taskmanagementsystem.data.repoInter.impl.UserImpl;
import com.example.taskmanagementsystem.dto.request.AuthRequest;
import com.example.taskmanagementsystem.dto.response.RegistrationUserDto;
import com.example.taskmanagementsystem.models.User;
import com.example.taskmanagementsystem.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserImpl userImpl;


    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private PermissionsImpl permission;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userImpl.getUserByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User Not found");
        }
    }

    public User getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

    public User findByUsername(String username) {
        return userImpl.getUserByEmail(username);
    }

    public User createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setEmail(registrationUserDto.getEmail());
        user.setPermissions(permission.getPermissionById(1L));
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        return userImpl.addUser(user);
    }

    public String authUser(AuthRequest authRequest){
        UserDetails userDetails = null;
        try {
            userDetails = loadUserByUsername(authRequest.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
        assert userDetails != null;
        return jwtTokenUtils.generateToken(userDetails);
    }
    public User getProfile(String token){
        return userImpl.getUserByEmail(jwtTokenUtils.extractUsername(token));
    }
}