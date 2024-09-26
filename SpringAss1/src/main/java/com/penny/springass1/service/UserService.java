package com.penny.springass1.service;


import com.penny.springass1.entity.User;
import com.penny.springass1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository  = userRepository;
    }

    public User[] getUsers(){
        return userRepository.getUsers();
    }

    public User getUserById(Long id){
        return userRepository.getUsersById(id);
    }

    public User createNewUser(User user){
        return userRepository.creatNewUser(user);
    }

    public User updateUserById(Long id, User user){
        return userRepository.updateUserById(id, user);
    }

    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }
}
