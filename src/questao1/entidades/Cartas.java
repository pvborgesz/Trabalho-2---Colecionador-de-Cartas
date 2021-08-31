package questao1.entidades;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public abstract class Cartas implements Comparable<Cartas>, Organizador{
    protected String nome;
    protected Integer custo;
    protected String raridade;
    protected String tipo;
    protected Integer ataque;
    protected Integer defesa;
    protected Integer qtd;

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Cartas(String nome, Integer custo, String raridade, String tipo, Integer ataque, Integer defesa, Integer qtd) {
        this.nome = nome;
        this.custo = custo;
        this.raridade = raridade;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.qtd = qtd;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    @Override
    public String toString() {
        return ": " +
                "nome: " + nome + ' ' +
                ", custo: " + custo +
                ", raridade " + raridade + ' ' +
                ", tipo: " + tipo + ' ' +
                ", ataque: " + ataque +
                ", defesa: " + defesa +
                " <-"+ "\n";
    }
    public int compareTo(Cartas o) {
        /*
            -1: menor
             0: igual
             1: maior
         */
        return this.nome.compareTo(o.getNome());
    }

    public void organizarTrocas(LinkedList<Cartas> cartas) {
        LinkedList<Cartas> cartasTrocas = new LinkedList<>();
        Scanner leitor = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);
        System.out.println("As cartas disponiveis são: ");
        for(int i=0; i<cartas.size(); i++){
            System.out.println(i+1 + " -> " + cartas.get(i).toString());
        }
        System.out.println("A carta que você deseja trocar está cadastrada? (1 - Sim\n2-Nao)");
        String opTroca = leitor.nextLine();

        if (opTroca.equalsIgnoreCase("1")){
            System.out.println("digite o indice da carta que você deseja trocar: ");
            int op = leitorInt.nextInt();
            System.out.println("A carta escolhida foi: " + cartasTrocas.get(op).toString());
            System.out.println("Digite o valor dela para trocas (valor inteiro no intervalo 0-10): ");
            int opCusto = leitorInt.nextInt();
            cartasTrocas.get(op).setCusto(opCusto);
            System.out.println("Agora a carta tem as seguintes caracteristicas: " + cartasTrocas.get(op).toString());
        }
    }




}
