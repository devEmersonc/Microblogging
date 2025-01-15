package com.devemersonc.microblogging.service;

import com.devemersonc.microblogging.dto.RegisterUserDTO;
import com.devemersonc.microblogging.dto.UserDTO;
import com.devemersonc.microblogging.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    void saveNormalUser(RegisterUserDTO registerUserDTO);
    void saveAdminUser(RegisterUserDTO registerUserDTO);
    void updateUser(Long id, RegisterUserDTO registerUserDTO);
    void deleteUser(Long id);
    UserDTO convertEntityToDto(User user);
}
