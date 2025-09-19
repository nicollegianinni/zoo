package com.zoo.proj.repository;

import com.zoo.proj.model.Animais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimaisRepository extends JpaRepository<Animais,String> {
    List<Animais> findById(); // pelo nome
    List<Animais> findByIdade(int idade); // Busca todos os animais com idade igual
    List<Animais> findByIdadeGreaterThanEqual(int idade);// Caso queira buscar animais com idade maior ou igual
    List<Animais> findByIdadeLessThan(int idade); // Ou animais com idade menor ou igual
}

