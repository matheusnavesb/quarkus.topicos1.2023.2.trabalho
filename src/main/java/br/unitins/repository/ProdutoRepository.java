package br.unitins.repository;

//import java.util.List;

import br.unitins.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

    public PanacheQuery<Produto> findByNome(String nome){
        if(nome == null){
            return null;
        }

        return find("UPPER(nome) LIKE ?1 ", "%" +nome.toUpperCase() + "%");
    }
    
}
