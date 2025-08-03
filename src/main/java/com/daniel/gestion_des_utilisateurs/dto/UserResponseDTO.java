package com.daniel.gestion_des_utilisateurs.dto;

import lombok.Data;
import java.util.List;


@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<String> roles;
}
