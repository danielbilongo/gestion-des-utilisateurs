package com.daniel.gestion_des_utilisateurs.service;

import com.daniel.gestion_des_utilisateurs.dto.AuthRequestDTO;
import com.daniel.gestion_des_utilisateurs.model.User;
import com.daniel.gestion_des_utilisateurs.repository.UserRepository;
import com.daniel.gestion_des_utilisateurs.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String authenticate(AuthRequestDTO auth) {
        User user = repository.findByEmail(auth.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email"));

        if (!passwordEncoder.matches(auth.getPassword(), user.getPassword()))
            throw new BadCredentialsException("Invalid password");

        return jwtUtil.generateToken(user);
    }
}