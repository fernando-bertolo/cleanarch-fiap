package br.com.bertolo.cleanarchfiap.core.usecases;

import br.com.bertolo.cleanarchfiap.core.entities.Estudante;
import br.com.bertolo.cleanarchfiap.core.exceptions.EstudanteNaoEncontradoException;
import br.com.bertolo.cleanarchfiap.core.interfaces.IEstudanteGateway;

public class BuscarEstudantePorNomeUseCase {
    private final IEstudanteGateway estudanteGateway;

    private BuscarEstudantePorNomeUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public static BuscarEstudantePorNomeUseCase create(IEstudanteGateway estudanteGateway) {
        return new BuscarEstudantePorNomeUseCase(estudanteGateway);
    }

    public Estudante run(String nome) {
        Estudante estudante = this.estudanteGateway.buscarPorNome(nome);
        if(estudante == null) {
            throw new EstudanteNaoEncontradoException("Estudante não encontrado");
        }

        return estudante;
    }

}
