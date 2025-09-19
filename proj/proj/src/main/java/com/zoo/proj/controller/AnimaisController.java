package com.zoo.proj.controller;

import com.zoo.proj.model.Animais;
import com.zoo.proj.service.CadastrarAnimaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
public class AnimaisController {

    @Autowired
    private CadastrarAnimaisService cadastrarAnimaisService;

    //lista de animais geral
    @GetMapping("/LitaDeAnimais")
    public ResponseEntity<List<Animais>> getAll() {
        return ResponseEntity.ok(cadastrarAnimaisService.ListaDeAnimais());
    }

    //cadastrar animais
    @PostMapping("/cadastrarAnimais")
    public Animais cadastrarAnimais(@RequestBody Animais animais) {
        return cadastrarAnimaisService.cadastrarAnimal (animais.getNome(), animais.getIdade());
    }

    //buscar animal pelo nome
    @GetMapping("/animais/{nome}")
    public Animais BuscarAnimal(@PathVariable Animais animais) {
        return cadastrarAnimaisService.cadastrarAnimal (animais.getNome(), animais.getIdade());
    }

    //buscar animais pela idade maior que
    @GetMapping("/idadeAnimais")
    public Animais idadeMaiorQue(@PathVariable Animais animais) {
        return cadastrarAnimaisService.cadastrarAnimal (animais.getNome(), animais.getIdade());
    }

}
