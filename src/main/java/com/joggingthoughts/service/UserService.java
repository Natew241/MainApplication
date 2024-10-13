package com.joggingthoughts.service;

import com.joggingthoughts.domain.UserEntity;
import com.joggingthoughts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserByID(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity getUserByName(String name){
        return userRepository.findByName(name);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
