package com.wsiiz.gamemanager.service.sign;

import com.wsiiz.gamemanager.message.request.RegisterRequest;
import com.wsiiz.gamemanager.message.request.SignInRequest;
import com.wsiiz.gamemanager.message.response.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface SignService {
    void signUp(RegisterRequest signUpRequest);

    JwtResponse signIn(SignInRequest signInRequest);
}
