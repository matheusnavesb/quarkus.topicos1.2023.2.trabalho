package br.unitins.dto;

import br.unitins.model.Produto;

public record ProdutoResponseDTO(
    Long id,
    String nome,
    String descricao,
    Double preco,
    Integer estoque
) {

    public static ProdutoResponseDTO valueOf(Produto produto) {
        return new ProdutoResponseDTO(
        produto.getId(),
        produto.getNome(),
        produto.getDescricao(),
        produto.getPreco(),
        produto.getEstoque()
        );
}
}
