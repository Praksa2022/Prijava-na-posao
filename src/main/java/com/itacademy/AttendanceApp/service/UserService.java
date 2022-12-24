package com.itacademy.AttendanceApp.service;

import com.itacademy.AttendanceApp.entity.User;
import com.itacademy.AttendanceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User updateResponse = userRepository.save(user);
        return updateResponse;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
