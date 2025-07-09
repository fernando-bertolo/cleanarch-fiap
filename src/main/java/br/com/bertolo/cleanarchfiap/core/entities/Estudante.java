package br.com.bertolo.cleanarchfiap.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
@EqualsAndHashCode
public class Estudante {
    @Setter
    private String identificacaoInterna;
    @Setter
    private String nome;
    private String enderecoEmail;
    private int idade;


    public Estudante(){}

    public Estudante(String identificacaoInterna, String nome, String enderecoEmail, int idade) {
        idadeValida(idade);
        enderecoEmailValido(enderecoEmail);

        this.identificacaoInterna = identificacaoInterna;
        this.nome = nome;
        this.enderecoEmail = enderecoEmail;
        this.idade = idade;
    }

    public static Estudante create(String nome, String enderecoEmail, int idade) throws IllegalArgumentException {
        if(nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Nome e email não podem ser nulos");
        }

        idadeValida(idade);
        enderecoEmailValido(enderecoEmail);

        Estudante estudante = new Estudante();
        estudante.setIdade(idade);
        estudante.setNome(nome);
        estudante.setEnderecoEmail(enderecoEmail);
        return estudante;
    }

    private static void idadeValida(int idade) {
        if(idade <= 18){
            throw new IllegalArgumentException("Idade deve ser maior ou igual a 18 anos");
        }
    }

    private static void enderecoEmailValido(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(!emailValidator.isValid(email)){
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public void setEnderecoEmail(String enderecoEmail) {
        enderecoEmailValido(enderecoEmail);
        this.enderecoEmail = enderecoEmail;
    }

    public void setIdade(int idade) {
        idadeValida(idade);
        this.idade = idade;
    }
}
