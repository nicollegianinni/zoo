package com.zoo.proj.repository;

import com.zoo.proj.model.Animais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimaisRepository extends JpaRepository<Animais,String> {

    //nao precisa usar o findAll ou findById pois é redundante ja que o JPA tras nativamente.
    List<Animais> findByNome(String nome); // buscar animal pelo nome
    List<Animais> findByIdade(int idade); // buscar todos os animais com idade

    List<Animais> findByIdadeGreaterThanEqual(int idade);//  buscar animais com idade maior ou igual
    List<Animais> findByIdadeLessThan(int idade); //  buscar animais com idade menor ou igual

}

