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
    public void adicionarCarta(Cartas carta, LinkedList<Cartas> listaCartas) {
        if(listaCartas.contains(carta)){
            System.out.println("Parece que você já tinha uma carta igual a essa, bacana, acho que estamos vendo um colecionador!");
        }
        listaCartas.add(carta);
        System.out.println("Carta cadastrada com sucesso");
        System.out.println("A carta cadastrada foi " + carta.toString());
    }
    public String agirCarta(Cartas carta) {
        return "feitico nao possui nenhuma acao possivel, perdao!";
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
