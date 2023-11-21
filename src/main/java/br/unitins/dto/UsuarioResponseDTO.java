package br.unitins.dto;

import java.util.List;

import br.unitins.model.Perfil;
import br.unitins.model.Usuario;

public record UsuarioResponseDTO(

    Long id,
    String nome,
    String login,
    Perfil perfil,
    List<TelefoneDTO> listaTelefone
) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){

        if(usuario == null){
            return null;
        }
        
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getLogin(),
            usuario.getPerfil(),
            usuario.getListaTelefone()
                .stream()
                .map(t -> TelefoneDTO.valueOf(t)).toList()
        );
    }
}
