package br.unitins.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(

    @NotEmpty(message = "Este campo não pode ser nulo.")
    String login,
    @NotEmpty(message = "Este campo não pode ser nulo.")
    String senha
) {
    
}
