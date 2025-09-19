package com.zoo.proj.service;

import com.zoo.proj.model.Animais;
import com.zoo.proj.repository.AnimaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarAnimaisService {
    private AnimaisRepository animaisRepository;

    public Animais cadastrarAnimal(String nome, int idade) {
        Animais animais = new Animais(nome, idade);
        return animaisRepository.save(animais);
    }

    public List<Animais> ListaDeAnimais() {
        return animaisRepository.findAll();
    }

    public List<Animais> ListaDeAnimaisPorIdade() {
        return animaisRepository.findById();
    }

}
