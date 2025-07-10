package br.com.bertolo.cleanarchfiap.core.gateways;

import br.com.bertolo.cleanarchfiap.core.dtos.EstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.dtos.NovoEstudanteDTO;
import br.com.bertolo.cleanarchfiap.core.entities.Estudante;
import br.com.bertolo.cleanarchfiap.core.exceptions.EstudanteNaoEncontradoException;
import br.com.bertolo.cleanarchfiap.core.interfaces.IDataSource;
import br.com.bertolo.cleanarchfiap.core.interfaces.IEstudanteGateway;

public class EstudanteGateway implements IEstudanteGateway {


    private final IDataSource dataStorageSource;

    private EstudanteGateway(IDataSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteGateway create(IDataSource dataStorageSource) {
        return new EstudanteGateway(dataStorageSource);
    }

    @Override
    public Estudante buscarPorNome(String nome) {
        EstudanteDTO estudanteDTO = this.dataStorageSource.obterEstudantePorNome(nome);
        if(estudanteDTO == null) {
            throw new EstudanteNaoEncontradoException("Estudante com o nome" + nome + "não encontrado");
        }
        return Estudante.create(
                estudanteDTO.identificacaoInterna(),
                estudanteDTO.nome(),
                estudanteDTO.enderecoEmail(),
                estudanteDTO.idade()
        );
    }

    @Override
    public Estudante incluir(Estudante novoEstudante) {
        final NovoEstudanteDTO novoEstudanteDTO = new NovoEstudanteDTO(
                novoEstudante.getNome(),
                novoEstudante.getEnderecoEmail(),
                novoEstudante.getIdade()
        );

        final EstudanteDTO estudanteCriado = this.dataStorageSource.incluirEstudante(novoEstudanteDTO);
        return Estudante.create(
                estudanteCriado.identificacaoInterna(),
                estudanteCriado.nome(),
                estudanteCriado.enderecoEmail(),
                estudanteCriado.idade()
        );
    }
}
