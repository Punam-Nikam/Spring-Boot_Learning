package com.udemy.punam.controller;

import com.udemy.punam.exceptionHandler.UserNotFoundException;
import com.udemy.punam.model.User;
import com.udemy.punam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class ReadUserById {

    @Autowired
    private UserRepository userRepository;

    ////Read user by id

        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
            return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not Found! with id - "+id));
        }
}
