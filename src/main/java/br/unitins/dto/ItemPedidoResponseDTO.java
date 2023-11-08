package br.unitins.dto;

import java.util.List;

import br.unitins.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Integer quantidade,
    Double preco,
    Long idProduto,
    String nome
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item){
        return new ItemPedidoResponseDTO(
            item.getQuantidade(),
            item.getPreco(),
            item.getProduto().getId(),
            item.getProduto().getNome());
    }

    public static List<ItemPedidoResponseDTO> valueOf(List<ItemPedido> item) {
        return item.stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList();
     }
}
