package br.unitins.dto;

import br.unitins.model.Produto;

public record ProdutoDTO(
    String nome,
    String descricao,
    Double preco,
    Integer estoque
) {
    public static ProdutoDTO valueOf(Produto produto){
        return new ProdutoDTO(
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getEstoque());
    }
}
