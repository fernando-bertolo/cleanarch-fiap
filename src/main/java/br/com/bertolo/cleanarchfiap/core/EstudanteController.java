package br.com.bertolo.cleanarchfiap.core;

import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.interfaces.IDataSource;
import br.com.bertolo.cleanarchfiap.core.usecases.CadastrarEstudanteUseCase;

public class EstudanteController {
    private final IDataSource dataStorageSource;

    private EstudanteController(IDataSource datasource) {
        this.dataStorageSource = datasource;
    }

    public static EstudanteController create(IDataSource datasource) {
        return new EstudanteController(datasource);
    }

    public EstudanteDTO cadastrar(NovoEstudanteDTO novoEstudanteDTO) {
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);
        var useCase = CadastrarEstudanteUseCase.create(estudanteGateway);

        try {
            var estudante = useCase.run(novoEstudanteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
