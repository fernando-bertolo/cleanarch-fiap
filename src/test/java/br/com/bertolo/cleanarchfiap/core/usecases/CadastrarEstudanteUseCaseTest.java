package br.com.bertolo.cleanarchfiap.core.usecases;

import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.entities.Estudante;
import br.com.bertolo.cleanarchfiap.core.exceptions.EstudanteJaExisteException;
import br.com.bertolo.cleanarchfiap.core.interfaces.IEstudanteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CadastrarEstudanteUseCaseTest {

    @Test
    @DisplayName("Cadastra com sucesso")
    void testRegistrandoOk() {
        // arrange
        String nomeTestar = "Fernando";
        String emailTestar = "fernando@gmail.com";
        int idadeTestar = 23;
        IEstudanteGateway estudanteGateway = mock(IEstudanteGateway.class);
        when(estudanteGateway.buscarPorNome(anyString())).thenReturn(
                null
        );
        when(estudanteGateway.incluir(any())).thenReturn(
                Estudante.create("abc", nomeTestar, emailTestar, idadeTestar)
        );

        //act

        final Estudante estudante = CadastrarEstudanteUseCase.create(estudanteGateway).run(
                new NovoEstudanteDTO(nomeTestar, emailTestar, idadeTestar)
        );

        // assert

        assertNotNull(estudante);
        assertEquals(estudante.getNome(), nomeTestar);
        assertEquals(estudante.getIdentificacaoInterna(), "abc");
    }

    @DisplayName("Cadastro sem sucesso")
    @Test
    void testErroNoRegistro() {
        // arrange
        String nomeTestar = "Nome teste";

        IEstudanteGateway estudanteGateway = mock(IEstudanteGateway.class);
        when(estudanteGateway.buscarPorNome(anyString())).thenReturn(
                Estudante.create("abc", "Fernando", "fernando@gmail.com", 23)
        );
        when(estudanteGateway.incluir(any())).thenReturn(
                Estudante.create("abc", nomeTestar, "fernando@gmail.com", 23)
        );

        assertThrows(EstudanteJaExisteException.class, () -> {
            final Estudante estudante = CadastrarEstudanteUseCase.create(estudanteGateway).run(
                    new NovoEstudanteDTO(nomeTestar, "fernando@gmail.com", 23)
            );
        });
    }
}