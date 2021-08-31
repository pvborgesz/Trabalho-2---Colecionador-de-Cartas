package questao1.entidades;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Feitico extends Cartas{
    public Feitico(String nome, Integer custo, String raridade, String tipo, Integer defesa, Integer ataque,Integer qtd){
        super(nome, custo, raridade, tipo,defesa,ataque,qtd);
    }

    @Override
    public int compareTo(Cartas o) {
        /*
            -1: menor
             0: igual
             1: maior
         */
        return this.nome.compareTo(o.getNome());
    }
}
