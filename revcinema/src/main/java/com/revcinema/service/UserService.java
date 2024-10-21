package com.revcinema.service;

import com.revcinema.dto.UserDTO;
import com.revcinema.model.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllUsers();
    Optional<UserDTO> findUserDTOById(Long id);  // Renamed for clarity
    UserDTO saveUserFromDTO(UserDTO user);  // Renamed for clarity
    void deleteUser(Long id);
    UserDTO saveUser(UsersEntity user);
    Optional<UsersEntity> findUserEntityById(Long id);
}
