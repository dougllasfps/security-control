package org.dougllas.securitycontrol.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.dougllas.securitycontrol.model.entity.User;
import org.dougllas.securitycontrol.validation.FieldMatch;

import javax.validation.constraints.NotNull;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */

@FieldMatch(first = "password", second = "passwordMatch", message = "Senhas não conferem.")
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String nome;

    @NotNull(message = "Campo login é obrigatório.")
    private String username;

    @NotNull(message = "Campo senha é obrigatório.")
    private String password;

    private String passwordMatch;

    private boolean authenticated;

    private String token;

    public static UserDTO entityToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setAuthenticated(user.getId() != null);
        dto.setId(user.getId());
        dto.setNome(user.getName());
        return dto;
    }

    public static User toEntity(UserDTO dto){
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setId(dto.getId());
        user.setName(dto.getNome());
        return user;
    }
}