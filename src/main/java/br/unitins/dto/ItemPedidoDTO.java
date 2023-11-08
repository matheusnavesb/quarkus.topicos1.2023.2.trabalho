package br.unitins.dto;

public record ItemPedidoDTO(
    Integer quantidade,
    Double preco,
    Long idProduto
) {
    
}
