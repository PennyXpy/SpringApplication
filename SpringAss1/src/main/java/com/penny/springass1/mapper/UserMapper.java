package com.penny.springass1.mapper;

import com.penny.springass1.dto.UserDTO;
import com.penny.springass1.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User transfer(UserDTO userDTO) {
        User newUser = new User();
        newUser.setId(userDTO.getId());
        return  newUser;
    }

}
