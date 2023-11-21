package br.unitins.dto;

import br.unitins.model.Categoria;
import br.unitins.model.Produto;

public record ProdutoResponseDTO(

    Long id,
    String nome,
    String descricao,
    Categoria categoria,
    Double preco,
    Integer estoque,
    String nomeImagem
) {

    public static ProdutoResponseDTO valueOf(Produto produto) {
        return new ProdutoResponseDTO(
        produto.getId(),
        produto.getNome(),
        produto.getDescricao(),
        produto.getCategoria(),
        produto.getPreco(),
        produto.getEstoque(),
        produto.getNomeImagem()
        );
}
}
