package com.zoo.proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animais {
    @Id
    private String nome;
    private int idade;

    public Animais(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Animais() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Animais{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
