package com.revcinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revcinema.model.UsersEntity;
import com.revcinema.repository.UserRepository;
import com.revcinema.dto.UserDTO;
import com.revcinema.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findUserDTOById(Long id) {
        return userRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UserDTO saveUserFromDTO(UserDTO userDTO) {
        UsersEntity userEntity = convertToEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UsersEntity savedUser = userRepository.save(userEntity);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO saveUser(UsersEntity user) {
        UsersEntity savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UsersEntity> findUserEntityById(Long id) {
        return userRepository.findById(id);
    }

    private UserDTO convertToDTO(UsersEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setIsAdmin(user.getIsAdmin());
        return userDTO;
    }

    private UsersEntity convertToEntity(UserDTO userDTO) {
        UsersEntity userEntity = new UsersEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setIsAdmin(userDTO.getIsAdmin());
        return userEntity;
    }
}
