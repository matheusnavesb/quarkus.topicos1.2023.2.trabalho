package br.unitins.service;

import br.unitins.dto.UsuarioResponseDTO;

public interface JwtService {
    
    public String generateJwt(UsuarioResponseDTO dto);
    
}
