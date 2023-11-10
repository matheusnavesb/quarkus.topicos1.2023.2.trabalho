package br.unitins.resource;

import br.unitins.dto.LoginDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.service.HashService;
import br.unitins.service.JwtService;
import br.unitins.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {
    
    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @POST
    public Response login(@Valid LoginDTO dto) {

        String hashSenha = hashService.getHashSenha(dto.senha());

        UsuarioResponseDTO result = service.findByLoginAndSenha(dto.login(), hashSenha);

        String token = jwtService.generateJwt(result);

        return Response.ok().header("Authorization", token).build();
    }
}
