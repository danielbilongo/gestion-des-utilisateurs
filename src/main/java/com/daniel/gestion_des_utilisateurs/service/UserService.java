package com.daniel.gestion_des_utilisateurs.service;

import com.daniel.gestion_des_utilisateurs.dto.UserRequestDTO;
import com.daniel.gestion_des_utilisateurs.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO request);
    UserResponseDTO updateUser(Long id, UserRequestDTO request);
    void deleteUser(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
}