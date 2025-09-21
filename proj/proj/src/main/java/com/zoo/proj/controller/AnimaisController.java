package com.zoo.proj.controller;

import com.zoo.proj.model.Animais;
import com.zoo.proj.repository.AnimaisRepository;
import com.zoo.proj.service.AnimaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //deletar por animal de modo simples com uma mensagem amigavel
//    @DeleteMapping("/deletaranimal/{nome}")
//    public ResponseEntity<String> deletarAnimal(@PathVariable String nome) {
//        animaisRepository.deleteById(nome);
//        return ResponseEntity.ok("Animal "+ nome + " apagado com sucesso!");
//    }

    //deletar de modo mais profissional, onde retorne um JSON com uma mensagem amigavel
    @DeleteMapping("/deletaranimal/{nome}")
    public ResponseEntity<Map<String, String>> deletarAnimal(@PathVariable String nome) {
        Map<String, String> resposta = new HashMap<>();

        if (animaisRepository.existsById(nome)) {
            animaisRepository.deleteById(nome);
            resposta.put("mensagem", " você deletou o animal " + nome + " com sucesso!");
            return ResponseEntity.ok(resposta);
        } else {
            resposta.put("erro", "O animal: " + nome + " não foi encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

}
