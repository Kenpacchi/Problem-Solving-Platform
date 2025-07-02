package com.problemSolvingPlatform.Problem.Solving.Platform.controller;

import com.problemSolvingPlatform.Problem.Solving.Platform.entity.User;
import com.problemSolvingPlatform.Problem.Solving.Platform.service.UserService;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/n")
    private void checkUser(@RequestBody User user){
        userService.checkCredentials(user);
    }

}
