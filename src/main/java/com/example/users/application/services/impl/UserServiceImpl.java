package com.example.users.application.services.impl;

import com.example.users.application.services.UserService;
import com.example.users.domain.User;
import com.example.users.infrastructure.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        log.info("Saving user: {}", user.toString());
        return this.userRepository.save(user);
    }

    public  User findById(Long id){
        return this.userRepository.findById(id).get();
    }
    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }

    public User updateById(Long Id, String email){
        var user = this.userRepository.findById(Id).get();
        if(user != null){
            user.setEmail(email);
            saveUser(user);
        }
        return user;
    }

}
