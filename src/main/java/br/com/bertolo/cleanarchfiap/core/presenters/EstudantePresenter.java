package br.com.bertolo.cleanarchfiap.core.presenters;

import br.com.bertolo.cleanarchfiap.core.dtos.EstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.entities.Estudante;

public class EstudantePresenter {
    public static EstudanteDTO toDTO(Estudante estudante) {
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        return new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEnderecoEmail()
        );
    }
}
