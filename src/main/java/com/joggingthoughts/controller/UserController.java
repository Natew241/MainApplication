package com.joggingthoughts.controller;

import com.joggingthoughts.domain.UserEntity;
import com.joggingthoughts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity user = userService.getUserByID(id);
        if (user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserEntity> getUserByName(@PathVariable String name){
        UserEntity user = userService.getUserByName(name);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email){
        UserEntity user = userService.getUserByEmail(email);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity newUser = userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails){
        UserEntity existingUser = userService.getUserByID(id);

        if (existingUser != null){
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());

            userService.createUser(existingUser);
            return ResponseEntity.ok(existingUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        UserEntity user = userService.getUserByID(id);

        if (user != null){
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
