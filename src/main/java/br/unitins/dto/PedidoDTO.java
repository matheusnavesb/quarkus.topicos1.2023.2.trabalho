package br.unitins.dto;

import java.util.List;

public record PedidoDTO(
    // FormaPagamento pagamento,
    // EnderecoDTO endereco,
    List<ItemPedidoDTO> itens
) {
    
}
