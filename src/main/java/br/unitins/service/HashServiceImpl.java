package br.unitins.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashServiceImpl implements HashService{

    // sequencia aleatória a ser adicionada na senha
    private String salt = "#blahxyz22";

    // contagem de iteracoes
    private Integer iterationCount = 405;

    // comprimento do hash em bits
    private Integer keyLength = 512;

    @Override
    public String getHashSenha(String senha) {
        
        try{
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                .generateSecret(
                    new PBEKeySpec(
                        senha.toCharArray(),
                        salt.getBytes(),
                        iterationCount,
                        keyLength))
                        .getEncoded();

                return Base64.getEncoder().encodeToString(result);
        }
        catch(InvalidKeySpecException | NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar um hash");
    }
    
}
    public static void main(String[] args){
        
        HashService service = new HashServiceImpl();

        System.out.println(service.getHashSenha("123"));
        System.out.println(service.getHashSenha("1234"));
        System.out.println(service.getHashSenha("12345"));
    }
}
