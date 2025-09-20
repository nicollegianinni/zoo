package com.zoo.proj.service;

import com.zoo.proj.model.Animais;
import com.zoo.proj.repository.AnimaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimaisService {
    private AnimaisRepository animaisRepository;

    // Injeção do construtor repository
    public AnimaisService(AnimaisRepository animaisRepository) {
        this.animaisRepository = animaisRepository;
    }

    public Animais cadastrarAnimais(String nome, int idade) { //cadastrar animais
        Animais animais = new Animais(nome, idade);
        return animaisRepository.save(animais);
    }

    public List<Animais> buscarAnimais() {
        return animaisRepository.findAll();
    }   // Lista geral de animais

    public List<Animais> listaDeAnimaisPorNome(String nome) {
        return animaisRepository.findByNome(nome);   //buscar animais pelo id, que é o nome
    }

    public List<Animais> listaDeAnimaisPorIdade(int idade) {   //  Buscar animais por idade exata
        return animaisRepository.findByIdade(idade);
    } //buscar por idade extata


    public List<Animais> listaDeAnimaisComMaior(int idade) {
        return animaisRepository.findByIdadeGreaterThanEqual(idade);
    } // Buscar animais com idade maior ou igual >

    //  Buscar animais com idade menor <
    public List<Animais> listaDeAnimaisMenorQue(int idade) {
        return animaisRepository.findByIdadeLessThan(idade);
    }


    //deletar
//    public List<Animais> deleteFindByIdAnimal(String nome) {
//        return animaisRepository.deleteFindByIdAnimal(nome);
//    }

//    public void deletarPorNomeEIdade(String nome, int idade) {
//        animaisRepository.deleteByNomeAndIdade(nome, idade);
//    }
}
