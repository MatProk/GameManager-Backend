package com.wsiiz.gamemanager.controller;

import com.wsiiz.gamemanager.domain.User;
import com.wsiiz.gamemanager.repository.UserRepository;
import com.wsiiz.gamemanager.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public User getProfile(@AuthenticationPrincipal UserPrinciple userPrinciple) {
        return userRepository.findByUsername(userPrinciple.getUsername()).get();
    }
}
