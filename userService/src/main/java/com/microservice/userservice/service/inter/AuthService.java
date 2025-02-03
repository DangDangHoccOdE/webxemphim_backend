package com.microservice.userservice.service.inter;

import com.microservice.userservice.entity.dto.UserAuthenticationResponseDto;
import com.microservice.userservice.entity.dto.UserLoginRequestDto;

public interface AuthService {
    UserAuthenticationResponseDto login(UserLoginRequestDto userLoginRequestDto);
}
