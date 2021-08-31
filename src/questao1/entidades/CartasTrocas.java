package questao1.entidades;

public class CartasTrocas {
    Cartas carta1;
    Cartas carta2;

    public CartasTrocas(Cartas cart1, Cartas carta2){
        this.carta1 = carta1;
        this.carta2 = carta2;
    }

    public Cartas getCarta1() {
        return carta1;
    }

    public void setCarta1(Cartas carta1) {
        this.carta1 = carta1;
    }

    public Cartas getCarta2() {
        return carta2;
    }

    public void setCarta2(Cartas carta2) {
        this.carta2 = carta2;
    }
}
