package br.unitins.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Telefone;
import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;
import br.unitins.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository repository;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {

       if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("login", "O login informado já existe, informe outro.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setLogin(dto.login());
        novoUsuario.setSenha(dto.senha());

        if (dto.listaTelefone() != null && 
                    !dto.listaTelefone().isEmpty()){
            novoUsuario.setListaTelefone(new ArrayList<Telefone>());

            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoUsuario.getListaTelefone().add(telefone);
            }
        }

        repository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto, Long id) {
        Usuario usuario = repository.findById(id);
        usuario.setLogin(dto.login());
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());

        List<Telefone> telefones = new ArrayList<>();
                for (TelefoneDTO tel : dto.listaTelefone()) {
                    Telefone telefone = new Telefone();
                    telefone.setCodigoArea(tel.codigoArea());
                    telefone.setNumero(tel.numero());
                    telefones.add(telefone);
                }

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
             return null;
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null) 
            throw new ValidationException("login", "Login ou senha inválido");
        
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) 
            throw new ValidationException("login", "Login inválido");
        
        return UsuarioResponseDTO.valueOf(usuario);
    }

    
}
