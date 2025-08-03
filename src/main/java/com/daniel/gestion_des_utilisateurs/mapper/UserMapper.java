package com.daniel.gestion_des_utilisateurs.mapper;




import com.daniel.gestion_des_utilisateurs.dto.UserRequestDTO;
import com.daniel.gestion_des_utilisateurs.dto.UserResponseDTO;
import com.daniel.gestion_des_utilisateurs.model.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {
    // Ignorer l'ID lors du mappage de UserRequestDTO vers User (car l'ID est généré par la DB)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserRequestDTO dto, @MappingTarget User entity);
}