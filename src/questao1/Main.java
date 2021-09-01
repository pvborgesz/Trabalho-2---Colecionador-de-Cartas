package questao1;
import questao1.entidades.*;
import questao1.controladores.*;
import java.text.DecimalFormat;
import java.util.*;

import static questao1.controladores.Controlador.agirCarta;


public class Main {

    public static void main(String[] args) {
        LinkedList<Cartas> cartasDeck1 = new LinkedList<>();
        LinkedList<Cartas> cartasDeck2 = new LinkedList<>();

        ArrayList<Cartas> trocasCadastradas = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);

        Controlador adicionadorEntidade = new Controlador(); // coloca dentro da lista as cartas

        int op;
        try {
            do {
                System.out.println("1 - cadastro de carta \n" +
                        "2 - consultar uma carta por tipo, cor ou raridade\n" +
                        "3 - listar todas as cartas \n" +
                        "4 - realizar acao com carta \n" +
                        "5 - verifica as repeticoes de cartas \n" +
                        "6 - sistema de trocas de cartas \n" +
                        "7 - duelo entre dois decks \n" +
                        "9 - Verificar regras do jogo \n" +
                        "0 - sair do programa.");
                op = leitorInt.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Se quiser inserir cartas para o deck 1, digite 1\n" +
                                "para cartas do deck 2, digite 2: ");

                        String opDeck = leitor.nextLine();

                        System.out.println("coloque o nome da carta: ");
                        String nome = leitor.nextLine();
                        System.out.println("coloque o custo da carta(valor inteiro): ");
                        Integer custo = leitorInt.nextInt();
                        System.out.println("coloque a raridade da carta(comum, incomum, raro, lendario): ");
                        String raridade = leitor.nextLine();
                        System.out.println("coloque o tipo da carta('criatura', 'feitico' ou 'encantamento')");
                        String tipo = leitor.nextLine();

                        switch (tipo) {
                            case "criatura":
                                //System.out.println("------ cadastro de cartas do tipo criatura ---------");
                                Criatura novaCriatura = new Criatura(nome, custo, raridade, tipo,0,0,1);
                                if(opDeck.equals("1")){
                                    adicionadorEntidade.adicionarCarta(novaCriatura, cartasDeck1);
                                }else{
                                    adicionadorEntidade.adicionarCarta(novaCriatura, cartasDeck2);
                                }

                                break;
                            case "feitico":
                                //System.out.println("------ cadastro de cartas do tipo feitico ---------");
                                Feitico novoFeitico = new Feitico(nome, custo, raridade, tipo,0,0,1);
                                if(opDeck.equals("1")){
                                    adicionadorEntidade.adicionarCarta(novoFeitico, cartasDeck1);
                                }else{
                                    adicionadorEntidade.adicionarCarta(novoFeitico, cartasDeck2);
                                }
                                break;
                            case "encantamento":
                                //System.out.println("------ cadastro de cartas do tipo encantamento ---------");
                                Encantamento novoEncantamento = new Encantamento(nome, custo, raridade, tipo,0,0,1);
                                if(opDeck.equals("1")){
                                    adicionadorEntidade.adicionarCarta(novoEncantamento, cartasDeck1);
                                }else{
                                    adicionadorEntidade.adicionarCarta(novoEncantamento, cartasDeck2);
                                }
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("-----sistema de consultas------");

                        System.out.println("digite por qual sistema você deseja buscar (criatura, feitico, encantamento, valor do custo, raridade):");
                        String tipoConsulta = leitor.nextLine();

                        consultarCarta(tipoConsulta, cartasDeck1); //funcao de busca

                        break;

                    case 3:
                        System.out.println("Se quiser listar cartas para o deck 1, digite 1\n" +
                                "para cartas do deck 2, digite 2: ");
                        opDeck = leitor.nextLine();
                        if(opDeck.equals("1")){
                            listarCartas(cartasDeck1);
                        }else{
                            listarCartas(cartasDeck2);
                        }
                        break;
                    case 4:
                        System.out.println("escolha a carta que deseja realizar uma ação: ");
                        System.out.println("Se quiser listar cartas para o deck 1, digite 1\n" +
                                "para cartas do deck 2, digite 2: ");
                        opDeck = leitor.nextLine();
                        if((opDeck.equals("1"))){
                            listarCartas(cartasDeck1);
                            Integer opcaoAcao = leitorInt.nextInt();
                            opcaoAcao --;
                            agirCarta(cartasDeck1.get(opcaoAcao));
                        }else{
                            listarCartas(cartasDeck2);
                            Integer opcaoAcao = leitorInt.nextInt();
                            opcaoAcao --;
                            agirCarta(cartasDeck2.get(opcaoAcao));
                        }
                        System.out.println("essas são as cartas disponiveis, escolha o indice da carta que deseja realizar alguma acao: ");
                         // pequeno ajuste pq na hora de exibir, o valor do indice é incrementado



                        break;
                    case 5:
                        System.out.println("Se quiser verificar repeticoes das cartas para o deck 1, digite 1\n" +
                                "para cartas do deck 2, digite 2: ");
                        opDeck = leitor.nextLine();
                        if((opDeck.equals("1"))){
                            verificarRepeticoes(cartasDeck1);
                            verificarRepeticoes(cartasDeck2);
                        }

                        break;
                    case 6:
                        System.out.println("Digite o nome da primeira carta da troca: ");
                        String nomeCarta1 = leitor.nextLine();
                        System.out.println("Digite o custo da primeira carta da troca: ");
                        Integer custoCarta1 = leitorInt.nextInt();
                        System.out.println("Digite o tipo da primeira carta da troca: ");
                        String tipoCarta1 = leitor.nextLine();

                        System.out.println("Digite o nome da segunda carta da troca: ");
                        String nomeCarta2 = leitor.nextLine();
                        System.out.println("Digite o custo da segunda carta da troca: ");
                        Integer custoCarta2 = leitorInt.nextInt();
                        System.out.println("Digite o tipo da segunda carta da troca: ");
                        String tipoCarta2 = leitor.nextLine();

                        if(adicionarCarta1(nomeCarta1, custoCarta1, tipoCarta1, tipoCarta1, cartasDeck1, trocasCadastradas) && adicionarCarta2(nomeCarta2, custoCarta2, tipoCarta2, tipoCarta2, cartasDeck2, trocasCadastradas)){
                            System.out.println("A possibilidade de troca foi cadastrada!");
                        }else{
                            System.out.println("foi adicionada na troca uma carta não cadastrada.");
                        }

                        for(int i =0 ; i<trocasCadastradas.size(); i++){
                            System.out.println("Temos essa troca cadastradada " + trocasCadastradas.get(i).toString());
                        }
                        break;
                    case 7:
                        Integer vidaJogador1=50;
                        Integer vidaJogador2=50;
                        double numRandomico = (Math.random()*3);


                        ArrayList<Cartas> dueloJogador1 = new ArrayList<>();
                        ArrayList<Cartas> dueloJogador2 = new ArrayList<>();
                        
                        Criatura criaturaDuelo1 = new Criatura("0",0,"0","0",0,0,0);
                        Encantamento encantamentoDuelo1 = new Encantamento("0", 0,"0", "0", 0, 0,0);
                        Feitico feiticoDuelo1 = new Feitico("0", 0, "0", "0",0,0,0);
                        Encantamento encantamentoDuelo2 = new Encantamento("0", 0,"0", "0", 0, 0,0);
                        Criatura criaturaDuelo2 = new Criatura("0",0,"0","0",0,0,0);
                        Feitico feiticoDuelo2 = new Feitico("0", 0, "0", "0",0,0,0);

                        System.out.println("é hora do duelo!");
                        System.out.println("\nEscolha com qual deck você deseja duelar: 1 ou 2 ");
                        opDeck = leitor.nextLine();
                        if((opDeck.equals("1"))){
                            for(int i=0; i<cartasDeck1.size(); i++){
                                dueloJogador1.add(cartasDeck1.get(i));
                            }
                        }else{
                            for(int i=0; i<cartasDeck1.size(); i++){
                                dueloJogador2.add(cartasDeck1.get(i));
                            }
                        }

                        for( int i =0 ; i < dueloJogador1.size(); i++){
                            System.out.println("as cartas do jogador 1 são: "+ dueloJogador1.get(i).toString() +"." );
                            if(dueloJogador1.get(i).getTipo().equalsIgnoreCase("criatura")){
                                criaturaDuelo1 = (Criatura) dueloJogador1.get(i);
                            }
                            if(dueloJogador1.get(i).getTipo().equalsIgnoreCase("feitico")){
                                feiticoDuelo1 = (Feitico) dueloJogador1.get(i);
                            } if(dueloJogador1.get(i).getTipo().equalsIgnoreCase("encantamento")){
                                encantamentoDuelo1 = (Encantamento) dueloJogador1.get(i);
                            }
                        }
                        for( int i =0 ; i < dueloJogador2.size(); i++){
                            System.out.println("as cartas do jogador 2 são: "+ dueloJogador2.get(i).toString() +"." );
                            if(dueloJogador2.get(i).getTipo().equalsIgnoreCase("criatura")){
                                criaturaDuelo2 = (Criatura) dueloJogador2.get(i);
                            }
                             if(dueloJogador2.get(i).getTipo().equalsIgnoreCase("feitico")){
                                feiticoDuelo2 = (Feitico) dueloJogador2.get(i);
                            } if(dueloJogador2.get(i).getTipo().equalsIgnoreCase("encantamento")){
                                encantamentoDuelo2 = (Encantamento) dueloJogador2.get(i);
                            }
                        }
                        
                        int contador = 0;
                        do{
                            //-------ATAQUE JOGADOR 1------------
                            System.out.println("o jogador 1 utilizou a carta "+ criaturaDuelo1.getNome()  + " e causou " + criaturaDuelo1.getAtaque() + " de dano!\n");
                            System.out.println("o jogador 2 possuia a carta " + criaturaDuelo2.getNome() + " que tinha uma defesa contra o ataque causado, reduzindo " + criaturaDuelo2.getDefesa() + " do dano causado!\n");
                            vidaJogador2 -= (criaturaDuelo1.getAtaque() - criaturaDuelo2.getDefesa());
                            //-------ATAQUE JOGADOR 2------------
                            System.out.println("o jogador 2 utilizou a carta "+ criaturaDuelo2.getNome()  + " e causou " + criaturaDuelo2.getAtaque() + " de dano!");
                            System.out.println("o jogador 1 possuia a carta " + criaturaDuelo1.getNome() + " que tinha uma defesa contra o ataque causado, reduzindo " + criaturaDuelo1.getDefesa() + " do dano causado! \n");
                            vidaJogador1 = (criaturaDuelo2.getAtaque() - criaturaDuelo1.getDefesa());

                            
                            if(contador == 1){
                                System.out.println("-----------------------------------------------");
                                System.out.println("olha que incrivel! o jogador 1 utilizou o feitico " + feiticoDuelo1.getNome() + " esse cara é muito habilidoso! é muito poder para um jogador só!");
                                System.out.println("olha que incrivel! o jogador 2 utilizou o feitico " + feiticoDuelo2.getNome() + " esse cara é muito habilidoso! é muito poder para um jogador só!");
                                System.out.println("-----------------------------------------------");
                            }
                            else{
                                System.out.println("o jogador 1 jogou o encantamento " + encantamentoDuelo1.getNome() + " pena que ele não foi efetivo! aparentemente ele não faz nada.");
                                System.out.println("o jogador 2 jogou o encantamento " + encantamentoDuelo2.getNome() + " FOI SUPER EFETIVO, causou 20 de dano no jogador inimigo!");
                                vidaJogador1 -= 50;
                            }
                            contador++;
                            if(vidaJogador1 <=0 || vidaJogador2 <= 0){
                                break;
                            }
                        }while(vidaJogador1>0 || vidaJogador2>0);

                        if (vidaJogador1<0){
                            System.out.println("*************************************");
                            System.out.println("PARABENS JOGADOR 2, VOCÊ VENCEU!");
                            System.out.println("*************************************");
                        }else{
                            System.out.println("*************************************");
                            System.out.println("PARABENS JOGADOR 1, VOCÊ VENCEU!");
                            System.out.println("*************************************");
                        }
                        break;
                    case 9:
                        System.out.println("O JOGO DE CARTAS POSSUI AS SEGUINTES REGRAS: \n" +
                                "as trocas são efetuadas pelo valor dado a carta. \n" +
                                "para fazer uma consulta, é necessario colocar uma chave desejada, por exemplo: " +
                                "quero buscar uma carta do tipo criatura, logo, digitarei 'criatura'. serve para custo da carta, deverá ser digitado '5'\n" +
                                "lembre-se que para duelar, é necessario realizar ação nas cartas para que elas tenham ataque e defesa. \n");
                        break;
                    case 0:
                        System.out.println("obrigado por usar o programa!");
                        break;
                    default:
                        System.out.println("opção invalida");
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("deu erro com essa coisa ai -> " + e.getClass());
        }
    }


    //--------------- METODOS UTILIZADOS ---------------//


    public static void consultarCarta(String tipoBusca, LinkedList<Cartas> cartas){
        for(int j = 0; j< cartas.size(); j++){
            if( (cartas.get(j).getTipo()).equalsIgnoreCase(tipoBusca) ){
                System.out.println("encontramos essa carta com a chave " + tipoBusca +" " + cartas.get(j).toString()+ "\n");
            }
            if( (cartas.get(j).getNome()).equalsIgnoreCase(tipoBusca) ){
                System.out.println("encontramos essa carta com a chave " + tipoBusca +" " + cartas.get(j).toString()+"\n");
            }
            if( (cartas.get(j).getRaridade()).equalsIgnoreCase(tipoBusca) ){
                System.out.println("encontramos essa carta com a chave " + tipoBusca +" " + cartas.get(j).toString() + "\n");
            }
        }
    }
    public static void listarCartas(LinkedList<Cartas> cartas){
        if(cartas.size()==0){
            System.out.println("não há cartas cadastradas nesse deck.\n");
        }
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println( (i+1) + " -> "+ cartas.get(i).getTipo().toUpperCase(Locale.ROOT) +  cartas.get(i).toString() + "\n");
        }
    }
    /*
    public static void agirCarta(Cartas carta) {
        Random aleatorio = new Random();
        double valor = (Math.random() * 50) ;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Diga qual acao deseja realizar (ataque ou defesa): ");
        String acao = leitor.nextLine();

        if(carta.getTipo().equalsIgnoreCase("feitico")){
            System.out.println("cartas do tipo feitico não tem ação de ataque e defesa!");
        }else{
            if (acao.equalsIgnoreCase("ataque")){
                System.out.println("A criatura selecionada foi buffada, recebeu " +  valor + " de ataque. ");
                Integer ataqueAtual = carta.getAtaque();
                carta.setAtaque((int) (ataqueAtual+valor));
            }else if (acao.equalsIgnoreCase("defesa")){
                System.out.println("A criatura selecionada foi buffada, recebeu " +  valor + " de defesa. ");
                Integer defesaAtual = carta.getDefesa();
                carta.setDefesa((int) (defesaAtual+valor));
            }
            System.out.println( "A carta agora tem as seguintes caracteristicas:  \n" + carta.toString() );
        }
    }
*/
    public static void verificarRepeticoes(LinkedList<Cartas> cartas){
        ArrayList<Cartas> cartasRepetidas = new ArrayList<>();
        ArrayList<Cartas> cartasAux = new ArrayList<>();

        for(int i=0; i<cartas.size() ;i++) {
            cartasAux.add(cartas.get(i));
        }
        if (cartasAux.size()==0){
            System.out.println("nao ha cartas cadastradas nesse deck.\n");
        }
        Collections.sort(cartasAux, Collections.reverseOrder());
        //cartasAux.sort();

            for(int i=0; i<cartas.size(); i++){
                for(int j=i+1 ; j<cartas.size(); j++){
                    if(cartasAux.get(i).getNome().equalsIgnoreCase(cartasAux.get(j).getNome())
                            && cartasAux.get(i).getTipo().equalsIgnoreCase(cartasAux.get(j).getTipo())){
                        cartasRepetidas.add(cartasAux.get(j));
                        cartasAux.get(i).setQtd(cartasAux.get(i).getQtd()+1);
                    }
                }
            }

        //System.out.println("No total, foram encontradas " + cartasRepetidas.size() + " cartas repetidas!\n");
        for(int i=0; i<cartasRepetidas.size(); i++){
                System.out.println((i+1) + " CARTA REPETIDA -> " + cartasRepetidas.get(i).toString() + " ");
        }
        cartasRepetidas.clear();
        cartasAux.clear();
    }

    public static boolean adicionarCarta1(String nome, Integer custo, String raridade, String tipo, LinkedList<Cartas> cartas,ArrayList<Cartas> trocasCadastradas){
        for (int i=0; i<cartas.size(); i++){
            if (cartas.get(i).getNome().equalsIgnoreCase(nome)){
                trocasCadastradas.add(cartas.get(i));
                return true;
            }
        }
        return false;
    }
    public static boolean adicionarCarta2(String nome, Integer custo, String raridade, String tipo, LinkedList<Cartas> cartas,ArrayList<Cartas> trocasCadastradas){
        for (int i=0; i<cartas.size(); i++){
            if (cartas.get(i).getNome().equalsIgnoreCase(nome)){
                trocasCadastradas.add(cartas.get(i));
                return true;
            }
        }
        return false;
    }

}
