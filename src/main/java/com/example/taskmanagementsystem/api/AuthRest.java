package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.request.AuthRequest;
import com.example.taskmanagementsystem.dto.request.RegistrationUserDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthRest {

    private final UserService userService;

    @PostMapping(value = "/auth")
    public CommonResponse authUser(@RequestBody AuthRequest authRequest){
        return userService.authUser(authRequest);
    }

    @PostMapping(value = "/registration")
    public CommonResponse addNewUser(@RequestBody RegistrationUserDto registrationUserDto){
        return userService.createNewUser(registrationUserDto);
    }
}
