package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.data.repoInter.impl.PermissionsImpl;
import com.example.taskmanagementsystem.data.repoInter.impl.UserImpl;
import com.example.taskmanagementsystem.dto.request.AuthRequest;
import com.example.taskmanagementsystem.dto.request.RegistrationUserDto;
import com.example.taskmanagementsystem.dto.response.UserDto;
import com.example.taskmanagementsystem.mapper.UserMapper;
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

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userImpl.getUserByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User Not found");
        }
    }

    public UserDto getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (UserDto) authentication.getPrincipal();
        }
        return null;
    }

    public UserDto findByUsername(String username) {
        return userMapper.toDto(userImpl.getUserByEmail(username));
    }

    public UserDto createNewUser(RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setEmail(registrationUserDto.getEmail());
        user.setName(registrationUserDto.getName());
        user.setPermissions(permission.getPermissionById(1L));
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        return userMapper.toDto(userImpl.addUser(user));
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
    public UserDto getProfile(String token){
        return userMapper.toDto(userImpl.getUserByEmail(jwtTokenUtils.extractUsername(token)));
    }
}