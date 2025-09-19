package com.zoo.proj.repository;

import com.zoo.proj.model.Animais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaisRepository extends JpaRepository<Animais,String> {
}
