package br.com.bertolo.cleanarchfiap.core.interfaces;

import br.com.bertolo.cleanarchfiap.core.dtos.EstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;

public interface IDataSource {
    EstudanteDTO obterEstudantePorNome(String nome);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudanteDTO);
}
