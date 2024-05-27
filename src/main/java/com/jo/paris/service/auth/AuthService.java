package com.jo.paris.service.auth;


import com.jo.paris.dto.ChangePasswordDto;
import com.jo.paris.dto.SignupRequest;
import com.jo.paris.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface AuthService {

     UserDto createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

     UserDto getUserById(Long userId);

     UserDto updateUser(UserDto userDto) throws IOException;

    ResponseEntity<?> updatePasswordById(ChangePasswordDto changePasswordDto);
}
