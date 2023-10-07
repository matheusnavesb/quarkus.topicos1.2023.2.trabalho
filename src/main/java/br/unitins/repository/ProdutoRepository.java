package br.unitins.repository;

import java.util.List;

import br.unitins.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public List<Produto> findByNome(String nome){
        return find("UPPER(nome) LIKE UPPER(?1)", "%"+nome+"%").list();
    }
    
}
