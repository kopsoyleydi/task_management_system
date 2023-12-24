package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.request.RegistrationUserDto;
import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/basic")
public class AuthRest {

    private final UserService userService;

    @PostMapping(value = "/addUser")
    public CommonResponse addNewUser(@RequestBody RegistrationUserDto registrationUserDto){
        try {
            return CommonResponse.builder()
                    .data(userService.createNewUser(registrationUserDto))
                    .message("New user added success")
                    .status(HttpStatus.CREATED)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Something went wrong")
                    .build();
        }
    }
}
