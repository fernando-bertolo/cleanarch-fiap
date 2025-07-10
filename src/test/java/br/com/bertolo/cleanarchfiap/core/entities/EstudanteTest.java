package br.com.bertolo.cleanarchfiap.core.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudanteTest {
    @DisplayName("Cria estudante com sucesso")
    @Test
    void testEstudanteOk() {
        // arrange
        String nome = "Fernando";
        String email = "fernando@gmail.com";
        int idade = 19;

        // act
        var estudante = Estudante.create(nome, email, idade);

        // assert
        assertEquals(nome, estudante.getNome());
        assertEquals(email, estudante.getEnderecoEmail());
        assertEquals(idade, estudante.getIdade());
    }

    @DisplayName("Cria estudante com identificação interna com sucesso")
    @Test
    void testEstudanteComIdentificacaoInterna() {
        // arrange
        String nome = "Fernando";
        String email = "fernando@gmail.com";
        int idade = 19;
        String identificacaoInterna = "123";

        // act
        var estudante = Estudante.create(identificacaoInterna, nome, email, idade);

        //assert
        assertEquals(nome, estudante.getNome());
        assertEquals(email, estudante.getEnderecoEmail());
        assertEquals(idade, estudante.getIdade());
        assertEquals(identificacaoInterna, estudante.getIdentificacaoInterna());
    }

}