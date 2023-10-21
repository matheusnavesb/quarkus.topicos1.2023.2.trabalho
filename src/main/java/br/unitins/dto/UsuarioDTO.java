package br.unitins.dto;

import java.util.List;

public record UsuarioDTO(

    String nome,
    String login,
    String senha,
    List<TelefoneDTO> listaTelefone
) {
    
    
}
