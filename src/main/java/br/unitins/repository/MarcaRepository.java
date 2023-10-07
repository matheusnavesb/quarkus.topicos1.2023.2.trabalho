package br.unitins.repository;

import java.util.List;

import br.unitins.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {
    public List<Marca> findByNome(String nome){
        return find("UPPER(nome) LIKE UPPER(?1)", "%"+nome+"%").list();
    }

}
