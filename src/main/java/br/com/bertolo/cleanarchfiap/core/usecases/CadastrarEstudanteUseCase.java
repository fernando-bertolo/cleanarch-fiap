package br.com.bertolo.cleanarchfiap.core.usecases;

import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.entities.Estudante;
import br.com.bertolo.cleanarchfiap.core.exceptions.EstudanteJaExisteException;
import br.com.bertolo.cleanarchfiap.core.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {
    private IEstudanteGateway estudanteGateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway estudanteGateway) {
        return new CadastrarEstudanteUseCase(estudanteGateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) {
        final Estudante estudanteExistente = estudanteGateway.buscarPorNome(novoEstudanteDTO.nome());
        if (estudanteExistente != null) {
            throw new EstudanteJaExisteException("Estudante" + novoEstudanteDTO.nome() + "já existe");
        }

        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.email(),
                novoEstudanteDTO.idade()
        );

        Estudante estudante = this.estudanteGateway.incluir(novoEstudante);
        return estudante;
    }
}
