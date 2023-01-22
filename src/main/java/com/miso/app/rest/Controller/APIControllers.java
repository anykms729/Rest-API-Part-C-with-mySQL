package com.miso.app.rest.Controller;

import com.miso.app.rest.Models.User;
import com.miso.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIControllers {

    @Autowired
    private UserRepo userRepo;

    // The default end-point that gets hit when accessing an application
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    // If URL "http://localhost:8080/users" is entered,it will return all users' list
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    // POST method is used to save data to database,and user info is sent through JSON
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "User information is saved successfully!";
    }

    // PUT method is used to update data to database
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        // Use predefined methods by calling object of user repository which is created with JPA repository extended.
        // First, find user information by ID which should be updated
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "User information is updated successfully!";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "User information with the ID: "+id+" is deleted successfully!";
    }
}
