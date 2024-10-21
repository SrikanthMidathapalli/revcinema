package com.revcinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.revcinema.dto.UserDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UserControllerInterface {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(@PathVariable Long id);
    ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user);
    void deleteUser(@PathVariable Long id);
}
