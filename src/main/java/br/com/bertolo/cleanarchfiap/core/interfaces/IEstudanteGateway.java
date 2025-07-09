package br.com.bertolo.cleanarchfiap.core.interfaces;

import br.com.bertolo.cleanarchfiap.core.entities.Estudante;

public interface IEstudanteGateway {
    Estudante buscarPorNome(String nome);

    Estudante incluir(Estudante novoEstudante);
}
