package br.unitins.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.dto.MarcaDTO;
import br.unitins.dto.MarcaResponseDTO;
import br.unitins.dto.ProdutoDTO;
import br.unitins.model.Marca;
import br.unitins.model.Produto;
import br.unitins.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MarcaServiceIpml implements MarcaService{

    @Inject
    MarcaRepository repository;

    @Override
    @Transactional
    public MarcaResponseDTO insert(MarcaDTO dto) {

        Marca novaMarca = new Marca();

        novaMarca.setNome(dto.nome());
        novaMarca.setDescricao(dto.descricao());

        if (dto.listaProduto() != null && 
                    !dto.listaProduto().isEmpty()){
            novaMarca.setProduto(new ArrayList<Produto>());
            for (ProdutoDTO prod : dto.listaProduto()) {
                Produto produto = new Produto();
                produto.setNome(prod.nome());
                produto.setDescricao(prod.descricao());
                produto.setPreco(prod.preco());
                produto.setEstoque(prod.estoque());
                
                novaMarca.getListaProduto().add(produto);
            }
        }

        repository.persist(novaMarca);

        return MarcaResponseDTO.valueOf(novaMarca);
    }

    @Override
    @Transactional
    public MarcaResponseDTO update(MarcaDTO dto, Long id) {
        Marca marca = repository.findById(id);

        marca.setNome(dto.nome());
        marca.setDescricao(dto.descricao());

        // falta a implementacao dos telefones
        // vcs (ALUNOS) devem implementar!!!!!

        if (dto.listaProduto() != null && 
                    !dto.listaProduto().isEmpty()){
            marca.setProduto(new ArrayList<Produto>());
            for (ProdutoDTO prod : dto.listaProduto()) {
                Produto produto = new Produto();
                produto.setNome(prod.nome());
                produto.setDescricao(prod.descricao());
                produto.setPreco(prod.preco());
                produto.setEstoque(prod.estoque());
                
                marca.getListaProduto().add(produto);
            }
        }

        
        return MarcaResponseDTO.valueOf(marca);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
        return MarcaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
             return null;
    }

    @Override
    public List<MarcaResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> MarcaResponseDTO.valueOf(e)).toList();
    }
    
}
