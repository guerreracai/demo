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

    @Override
    public  User findById(Long id){
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateById(User user){
        return this.userRepository.save(user);
    }


}
