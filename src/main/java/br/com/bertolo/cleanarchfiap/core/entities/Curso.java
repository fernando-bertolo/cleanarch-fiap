package br.com.bertolo.cleanarchfiap.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Curso {
    private String nome;
    private boolean ativo;
    private ArrayList<Estudante> estudantes = new ArrayList<>();

    public Curso(String nome, boolean ativo) {
        this.nomeValido(nome);
        this.nome = nome;
        this.ativo = ativo;
    }

    private void nomeValido(String nome) {
        if(nome.trim().isBlank()) {
            throw new InvalidParameterException("Nome inválido");
        }
    }
}
