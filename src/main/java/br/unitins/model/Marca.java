package br.unitins.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Marca extends DefaultEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="marca_produto",
        joinColumns= @JoinColumn(name="id_marca"),
        inverseJoinColumns = @JoinColumn(name="id_produto") )
    private List<Produto> listaProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
}   
