package br.unitins.dto;

//import br.unitins.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProdutoDTO(

    @NotBlank(message = "O campo nome deve ser informado.")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")

    String nome,
    String descricao,
    Integer idCategoria,
    Double preco,
    Integer estoque
) {
    /*
    public static ProdutoDTO valueOf(Produto produto){
        return new ProdutoDTO(
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getEstoque());
    } */
}
