package com.microservice.userservice.controller;

import com.microservice.userservice.entity.dto.UserAuthenticationResponseDto;
import com.microservice.userservice.entity.dto.UserLoginRequestDto;
import com.microservice.userservice.service.inter.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public UserAuthenticationResponseDto login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        return authService.login(userLoginRequestDto);
    }
}
