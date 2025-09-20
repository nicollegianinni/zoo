package com.zoo.proj.controller;

import com.zoo.proj.model.Animais;
import com.zoo.proj.repository.AnimaisRepository;
import com.zoo.proj.service.AnimaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping
public class AnimaisController {

    @Autowired
    private AnimaisService animaisService;

    @Autowired
    private AnimaisRepository animaisRepository; // para deletar diretamente dop db

    //lista de animais geral
    @GetMapping("/listaanimais")
    public ResponseEntity<List<Animais>> getAll() {
        return ResponseEntity.ok(animaisService.buscarAnimais());
    }

    //cadastrar animais
    //obs.: como o Id primary key é o nome do animal (independe de upcse etc)
    //algo escrever o nome do animal e mudar a idade ele altera como um metodo put
    @PostMapping("/cadastraranimais")
    public Animais cadastrarAnimais(@RequestBody Animais animais) {
        return animaisService.cadastrarAnimais(animais.getNome(), animais.getIdade());
    }

    //buscar animal pelo nome
    @GetMapping("/buscarporanimal/{nome}")
    public ResponseEntity<List<Animais>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisPorNome(nome));
    }

    //buscar animais pela idade exata
    @GetMapping("/buscarporidade/{idade}")
    public ResponseEntity<List<Animais>> buscarpelaIdade(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisPorIdade(idade));
    }

    //buscar animais pela idade maior que >
    @GetMapping("/idademaiorque/{idade}")
    public ResponseEntity<List<Animais>> buscarPorIdadeMaiorQue(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisComMaior(idade));
    }

    //buscar animais pela idade menor que <
    @GetMapping("/idademenorque/{idade}")
    public ResponseEntity<List<Animais>> buscarPorIdadeMenorQue(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisMenorQue(idade));
    }

    //deletar por animal
    @DeleteMapping("/deletaranimal/{nome}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable String nome) {
        animaisRepository.deleteById(nome);
        System.out.println("você deletou o animal " + nome);
        return ResponseEntity.noContent().build(); // Retorna 204
    }

//
//    @DeleteMapping("/deletaranimal/{id}")
//    public ResponseEntity<?> delete(@PathVariable String nome) {
//        return animaisRepository.findById(nome).map(resposta -> {
//            animaisRepository.deleteById(nome);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }).orElse(ResponseEntity.notFound().build());
//    }

}
