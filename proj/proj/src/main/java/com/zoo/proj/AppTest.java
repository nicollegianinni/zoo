package com.zoo.proj;

import com.zoo.proj.model.Animais;

public class App {
    public static void main(String[] args) {

        Animais animal1 = new Animais();
        animal1.setIdade(10);
        animal1.setNome("Gato");

        System.out.println(animal1);
    }
}
