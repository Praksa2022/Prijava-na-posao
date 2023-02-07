package com.itacademy.AttendanceApp.service;

import com.itacademy.AttendanceApp.entity.User;
import com.itacademy.AttendanceApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//   // public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

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

    public User findById(Long id) throws IOException {
        return userRepository.findById(id).orElseThrow(() -> new IOException("Nema usera"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
