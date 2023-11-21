package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.service.UsuarioService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioService usuarioService;


    @Test
    public void testFindAll() {
        given()
          .when().get("/usuarios")
          .then()
             .statusCode(200);
    }
    @Test
    public void testInsert(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        UsuarioDTO dto = new UsuarioDTO(
            "Joao Insert",
            "jaozinho",
            "333",
            1,
            telefones);

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/usuarios")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
         "nome",is("Joao Insert"),
         "login",is("joaozinho"));
    }

    @Test
    public void testUpdate(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","1111-1111"));
        UsuarioDTO dto = new UsuarioDTO(
             "Ronaldo Fenomeno",
            "ronaldo",
            "333",
            2,
            telefones);

        UsuarioResponseDTO usuarioTest = usuarioService.insert(dto);

        Long id = usuarioTest.id();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        UsuarioDTO dtoUpdate = new UsuarioDTO(
             "Ronaldo Fenomeno",
            "ronaldo",
            "345",
            1, 
            telefones);

        given()
        .contentType(ContentType.JSON)
        .body(dtoUpdate)
        .when().put("/usuarios/"+ id)
        .then()
        .statusCode(204);
    }
}
