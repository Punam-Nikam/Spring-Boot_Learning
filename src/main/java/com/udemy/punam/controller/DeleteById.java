package com.udemy.punam.controller;

import com.udemy.punam.exceptionHandler.UserNotFoundException;
import com.udemy.punam.model.User;
import com.udemy.punam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class DeleteById
{
    @Autowired
    private UserRepository userRepository;

    //// Delete user by id

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateuser(@PathVariable Long id){
        User userData = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id : "+id));
        userRepository.delete((userData));
        return ResponseEntity.ok().build();
    }
}
