package com.daniel.gestion_des_utilisateurs.dto;



import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;;
}