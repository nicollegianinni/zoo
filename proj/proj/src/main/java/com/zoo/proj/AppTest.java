package com.zoo.proj;

import com.zoo.proj.model.Animais;
import com.zoo.proj.service.AnimaisService;

public class AppTest {
    public static void main(String[] args) {

        Animais animal1 = new Animais();
        animal1.setIdade(15);
        animal1.setNome("Gato");

        //criando objeto semelhante, mas como é um novo objeto nao é igual
        Animais animal2 = new Animais();
        animal2.setNome("Gato");
        animal2.setIdade(15);

        System.out.println(animal1);
        System.out.println(animal2);

        System.out.println(animal1.equals(animal2)); // false
        System.out.println(animal1==animal2); //false

        System.out.println();

        // Observe acima que ele permite criar objetos com 'conteudo' igual;
        // mas no projeto não permite a criação de 2 objetos iguais por causa do JPA.
        // Normalmente a orimary key é uma numeração Long id,
        // Mas aqui nesse projeto colocamos como o 'nome' do animal, sinalizado pelo bean @Id do spring data
        //Por tanto quando tentar criar (POST /cadastaranimais) não criará,
        // e se modificar o campo 'idade' fará um UPDATE mesmo estando em modo POST (por debaixo dos panos faz um PUT)
        // OBSERVAÇÃO: MESMO QUE ESTEJA COM A LETRA DO NOME UP CASE (MAIUSCULA) E CADASTRE DEPOIS COM UM LOWCASE (MINUSCULA)
        // Ex.: Add no postman 'nome' tubarao e 'idade' 80 anos, depois add Tubarao e 100 anos. Ele fez up date.
        // OBSERVAÇÃO: Leve em consideração que nao há restrição quanto a espaços vazios, nulos, ou quantidade de caracteres.

    }
}
