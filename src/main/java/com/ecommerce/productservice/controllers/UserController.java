package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.dtos.GetInstructorDto;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

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
//    @GetMapping("/instructor/{name}")
//    public List<GetInstructorDto> GetInstructorByName(@PathVariable(name = "name") String name){
//        return userService.getInstructorByName(name);
//    }


//    @GetMapping("/instructor/{uuid}")
//    public GetInstructorDto GetInstructorByUUID(@PathVariable(name = "uuid") UUID uuid){
//        return userService.getInstructorById(uuid);
//    }

    @GetMapping("/instructor")
    public List<GetInstructorDto> GetInstructorByUUID(@RequestBody List<UUID> uuid){
        return userService.getInstructorByIds(uuid);
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
