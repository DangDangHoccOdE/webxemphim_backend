package com.microservice.userservice.service.inter;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.entity.dto.UserRegisterRequestDto;

public interface UserService {
    Boolean isUserExist(String userId);
    void addUser(UserRegisterRequestDto userRegisterRequestDto);
    User getUserByEmail(String email);
    boolean isUserCustomer();
    boolean isUserAdmin();
}
