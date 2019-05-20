package com.example.demo;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @PostMapping("/adduser")
    public UserResponse addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new UserResponse("Something went wrong");
        }
        
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return new UserResponse("User added!");
    }
}
