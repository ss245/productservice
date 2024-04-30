package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User CreateUser(@RequestBody CreateUserDto createUserDto ){
        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/{name}")
    public List<User> GetUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }

    // Create endpoint for instructor
    @GetMapping("/instructor/{name}")
    public List<Instructor> GetInstructorByName(@PathVariable(name = "name") String name){
        return userService.getInstructorByName(name);
    }


    // Try to create Instructor
    @PostMapping("/instructor")
    public Instructor CreateInstructor(@RequestBody CreateUserDto createUserDto ) {
        return userService.createInstructor(createUserDto.getName(), createUserDto.getEmail());
    }

    // Try to create Learner
    @PostMapping("/learner")
    public Learner CreateLearner(@RequestBody CreateUserDto createUserDto ){
        return userService.createLearner(createUserDto.getName(), createUserDto.getEmail());
    }


}
