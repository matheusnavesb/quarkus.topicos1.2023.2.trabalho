package br.unitins.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime dataHora,
    UsuarioResponseDTO usuario,
    Double totalPedido,
    List<ItemPedidoResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getId(), 
            pedido.getDataHora(),
            UsuarioResponseDTO.valueOf(pedido.getUsuario()),
            pedido.getTotalPedido(),
            ItemPedidoResponseDTO.valueOf(pedido.getItens()));
    }
}
