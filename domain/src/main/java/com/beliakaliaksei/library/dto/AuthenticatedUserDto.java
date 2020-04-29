package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.enumeration.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AuthenticatedUserDto {
    private Long id;
    @NotNull(message = "{valid.email.notNull}")
    @Email(message = "{valid.email.email}")
    private String email;
    @NotNull(message = "{valid.password.notNull}")
    @Size(min = 5, message = "{valid.password.size.min5}")
    private String password;
    private Role role;
}
