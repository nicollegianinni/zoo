package com.zoo.proj.controller;

import com.zoo.proj.model.Animais;
import com.zoo.proj.repository.AnimaisRepository;
import com.zoo.proj.service.AnimaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
public class AnimaisController {

    @Autowired
    private AnimaisService animaisService;
    private AnimaisRepository animaisRepository;

    //lista de animais geral
    @GetMapping("/ListaAnimais")
    public ResponseEntity<List<Animais>> getAll() {
        return ResponseEntity.ok(animaisService.buscarAnimais());
    }

    //cadastrar animais
    @PostMapping("/cadastrarAnimais")
    public Animais cadastrarAnimais(@RequestBody Animais animais) {
        return animaisService.cadastrarAnimais(animais.getNome(), animais.getIdade());
    }

    //buscar animal pelo nome
    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<Animais>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisPorNome(nome));
    }

    //buscar animais pela idade exata
    @GetMapping("/buscar/{idade}")
    public ResponseEntity<List<Animais>> buscarpelaIdade(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisPorIdade(idade));
    }

    //buscar animais pela idade maior que >
    @GetMapping("/buscar/{idade}")
    public ResponseEntity<List<Animais>> buscarPorIdadeMaiorQue(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisComMaior(idade));
    }

    //buscar animais pela idade menor que <
    @GetMapping("/buscar/{idade}")
    public ResponseEntity<List<Animais>> buscarPorIdadeMenorQue(@PathVariable int idade) {
        return ResponseEntity.ok(animaisService.listaDeAnimaisMenorQue(idade));
    }
}
