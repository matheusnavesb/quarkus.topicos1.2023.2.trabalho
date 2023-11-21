package br.unitins.repository;

import java.util.List;

import br.unitins.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class PedidoRepository implements PanacheRepository<Pedido> { 
    
    public List<Pedido> findAll(String login){
        return find("usuario.login = ?1", login).list();
    }

    public List<Pedido> findAll(Long idUsuario){
        return find("usuario.id = ?1", idUsuario).list();
    }
}
