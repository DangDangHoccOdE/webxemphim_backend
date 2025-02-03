package com.microservice.userservice.controller;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.entity.dto.UserRegisterRequestDto;
import com.microservice.userservice.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("isExist/{userId}")
    public boolean isExist(@PathVariable String userId) {
        return userService.isUserExist(userId);
    }

    @PostMapping("add")
    public void add(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        userService.addUser(userRegisterRequestDto);
    }

    @GetMapping("isUserCustomer")
    public boolean isUserCustomer() {
        return userService.isUserCustomer();
    }

    @GetMapping("isUserAdmin")
    public boolean isUserAdmin() {
        return userService.isUserAdmin();
    }


}
