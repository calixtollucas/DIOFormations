/*
Este programa tem como objetivo simular a plataforma DIO, criando um domínio com usuários relacionados com formações, e
estas com seus respectivos conteúdos. Cada conteúdo tem uma duração e concede ao usuário uma quantidade de "xp" ao
usuário que a assistir, os xp's recebidos serão acrescentados ao usuário e o faz ir subindo de nível, o que simularia o
conhecimento adquirido pelo usuário

//TODO(criar interface interativa via prompt);
 */

package application

import entities.ConteudoEducacional
import entities.Formacao
import entities.NivelFormacao
import entities.Usuario

fun main() {
    //Instanciação dos usuários
    val lucas = Usuario("Lucas", "lucas123@gmail.com", "lucas123");
    val pedro = Usuario("Pedro", "pedro123@gmail.com", "pedro123");
    val joao = Usuario("Joao", "joao123@gmail.com", "joao123");
    val talitha = Usuario("Talitha", "talitha123@gmail.com", "talitha123");
    val dayanne = Usuario("Dayanne", "dayanne123@gmail.com", "dayanne123");

    //Conteudos
    val introducaoJava: ConteudoEducacional = ConteudoEducacional("Introdução ao Java",
        55,
        listOf("Java"),
        500
        );
    val classesEObjetos: ConteudoEducacional = ConteudoEducacional("Classes e Objetos em Java",
        24,
        listOf("Java", "POO"),
        550
    );
    val pilaresPOO: ConteudoEducacional = ConteudoEducacional(
        "Pilares POO",
        60,
        listOf("Java", "POO"),
        1000
    );

    //Formação
    val formacaoJava = Formacao("Formação POO Java", NivelFormacao.INTERMEDIARIO, "William Suane");
    formacaoJava.addConteudo(introducaoJava, classesEObjetos, pilaresPOO);

    //adicionando usuarios
    formacaoJava.matricular(lucas, pedro, joao, talitha, dayanne);

    lucas.assistirConteudo(formacaoJava.conteudosView.get(0));
    lucas.assistirConteudo(formacaoJava.conteudosView.get(1));

    formacaoJava.exibirFormacao();
}