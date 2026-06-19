package com.udemy.punam.controller;

/// Building RESTful API : done!!

// whenever we want to create a RESTful web service, definitely we have to create a controller.
// Purpose of @Controller - This annotation tells spring that the class is a web controller
//  and that the return value of each method should be written directly to the HTTP response body rather than being render as a view.

import com.udemy.punam.model.User;
import com.udemy.punam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //it is convenience annotation that itself annotated with @Controller and @ResponseBody
@RequestMapping("/api/users")
public class CreateUserController {
    //this is simple rest api..
//    @GetMapping   // @GetMapping annotation is composed annotation that acts as a GET method
//    public String getUsers() {
//        return "Hello API";
//    }

    //this is simple but with data rest api..
//    @GetMapping   // @GetMapping annotation is composed annotation that acts as a GET method
//    public List<User> getUsers() {
//        return Arrays.asList(new User(1l,"virat","virat18@gmail.com"),
//                new User(1L,"rajat","rajat@123.com"));
//    }

    //now this is for connect to database
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();  //we get all the users
    }    // This creates the get request means in database table is created with column names.(but blank)
    //now we have to create another api that will be responsible to add user in database


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));     ///now password will save in database in encoding format
        return userRepository.save(user);  //add user details from postman and will save to database
    }
    //// we have created two api ,1-getmapping => //we get all the users
    ////                          2-postmapping => //add user details from postman and will save to database
}