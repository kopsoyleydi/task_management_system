package com.example.taskmanagementsystem.api;


import com.example.taskmanagementsystem.dto.response.CommonResponse;
import com.example.taskmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserRest {

    private final UserService userService;

    @GetMapping("/getUserByEmail")
    public CommonResponse getUserByEmail(@RequestParam String email){
        try {
            return CommonResponse.builder()
                    .data(userService.loadUserByUsername(email))
                    .status(HttpStatus.OK)
                    .build();
        }
        catch (Exception e){
            return CommonResponse.builder()
                    .status(HttpStatus.OK)
                    .message("User not found or something went wrong")
                    .build();
        }
    }
}
