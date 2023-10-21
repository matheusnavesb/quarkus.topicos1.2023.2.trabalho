package br.unitins.dto;

import br.unitins.model.Telefone;

public record TelefoneDTO(

    String codigoArea,
    String numero
) {
    
    public static TelefoneDTO valueOf(Telefone telefone){
        return new TelefoneDTO(
            telefone.getCodigoArea(),
            telefone.getNumero()
        );
    }
}
