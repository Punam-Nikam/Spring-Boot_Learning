package com.udemy.punam.controller;

import com.udemy.punam.exceptionHandler.UserNotFoundException;
import com.udemy.punam.model.User;
import com.udemy.punam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UpdateUserById
{
        @Autowired
        private UserRepository userRepository;

    ////Update user data by id

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id,@RequestBody User user) {
            User userData= userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not Found! with id - "+id));
            userData.setEmail(user.getEmail());
            userData.setName(user.getName());
            return userRepository.save(userData);
        }
}