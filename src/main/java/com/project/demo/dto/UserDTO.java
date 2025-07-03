package com.project.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO (
    @NotBlank(message = "O nome é obrigatório!")
    String name,

    @NotBlank(message = "o e-mail é obrigarório!")
    @Email(message = "E-mail inválido")
    String email,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres!")
    String senha

){
}
