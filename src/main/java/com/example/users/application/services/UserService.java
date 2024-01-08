package com.example.users.application.services;

import com.example.users.domain.User;

public interface UserService {
    User saveUser(User user);
    User findById(Long id);

    void deleteById(Long id);

    User updateById (Long id, String email);

}
