package br.com.bertolo.cleanarchfiap.core.controllers;

import br.com.bertolo.cleanarchfiap.core.dtos.EstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.exceptions.EstudanteJaExisteException;
import br.com.bertolo.cleanarchfiap.core.gateways.EstudanteGateway;
import br.com.bertolo.cleanarchfiap.core.interfaces.IDataSource;
import br.com.bertolo.cleanarchfiap.core.presenters.EstudantePresenter;
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
            return EstudantePresenter.toDTO(estudante);
        } catch (EstudanteJaExisteException e) {
            return null;
        }
    }

    public EstudanteDTO buscarPorNome(String nome) {
        /* ... */
        return null;
    }
}
