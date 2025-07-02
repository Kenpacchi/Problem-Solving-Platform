package com.problemSolvingPlatform.ProblemSolvingPlatform.controller;

import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.Problem;
import com.problemSolvingPlatform.ProblemSolvingPlatform.entity.User;
import com.problemSolvingPlatform.ProblemSolvingPlatform.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/leetApi/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    private String signUp(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @PostMapping("/login")
    private String login(@RequestBody User user){
        return userService.loginUser(user);
    }

}
