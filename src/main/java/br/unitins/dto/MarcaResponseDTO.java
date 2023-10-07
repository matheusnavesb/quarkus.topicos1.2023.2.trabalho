package br.unitins.dto;

import java.util.List;

import br.unitins.model.Marca;

public record MarcaResponseDTO(
    Long id,
    String nome,
    String descricao,
    List<ProdutoDTO> listaProduto 
) {
    public static MarcaResponseDTO valueOf(Marca marca){
        
        return new MarcaResponseDTO(
            marca.getId(),
            marca.getNome(),
            marca.getDescricao(),
            marca.getListaProduto()
                .stream()
                .map(t -> ProdutoDTO.valueOf(t)).toList()
        );
    }
}