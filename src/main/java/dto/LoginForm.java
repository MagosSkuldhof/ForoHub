package com.tuusuario.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(
        @NotBlank(message = "Usuario es obligatorio") String username,
        @NotBlank(message = "Contraseña es obligatoria") String password
) {}
