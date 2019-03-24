package com.wsiiz.gamemanager.controller;

import com.wsiiz.gamemanager.message.request.RegisterRequest;
import com.wsiiz.gamemanager.message.request.SignInRequest;
import com.wsiiz.gamemanager.message.response.JwtResponse;
import com.wsiiz.gamemanager.service.sign.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api/auth")
public class SignController {

	@Autowired
	SignService signService;

	public SignController(SignService signService) {
		this.signService = signService;
	}


	@PostMapping("/signin")
	public JwtResponse authenticateUser(@RequestBody SignInRequest loginRequest) {
		return signService.signIn(loginRequest);
	}

	@PostMapping("/signup")
	public void signUp(@RequestBody RegisterRequest signUpRequest) {
		signService.signUp(signUpRequest);
	}
}