package questao1.controladores;

import questao1.entidades.Cartas;

import java.util.*;

public class Controlador {
    public void adicionarCarta(Cartas carta, LinkedList<Cartas> listaCartas) {
        if(listaCartas.contains(carta)){
            System.out.println("Parece que você já tinha uma carta igual a essa, bacana, acho que estamos vendo um colecionador!");
        }
        listaCartas.add(carta);
        System.out.println("Carta cadastrada com sucesso");
        System.out.println("A carta cadastrada foi " + carta.toString());
    }
    public String agirCarta(Cartas carta) {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt();
        Scanner leitor = new Scanner(System.in);

        String acao = leitor.nextLine();

        if (acao.toLowerCase(Locale.ROOT) == "ataque"){
            System.out.println("A criatura selecionada foi buffada, recebeu " +  valor + "de ataque. ");
            Integer ataqueAtual = carta.getAtaque();
            carta.setAtaque(ataqueAtual+valor);
        }else{
            System.out.println("A criatura selecionada foi buffada, recebeu " +  valor + "de defesa. ");
            Integer defesaAtual = carta.getDefesa();
            carta.setDefesa(defesaAtual+valor);
        }
        return "A carta agora tem as seguintes caracteristicas:  \n" + carta.toString();
    }
}
