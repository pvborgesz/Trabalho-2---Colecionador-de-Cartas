package questao1;
import questao1.entidades.*;

import java.text.DecimalFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        LinkedList<Cartas> cartas = new LinkedList<>();
        ArrayList<Cartas> trocasCadastradas = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);
        DecimalFormat formatador = new DecimalFormat("0.00");



        int op;
        try {
            do {
                System.out.println("1 - cadastro de carta \n" +
                        "2 - consultar uma carta por tipo, cor ou raridade\n" +
                        "3 - listar todas as cartas \n" +
                        "4 - realizar acao com carta \n" +
                        "5 - verifica as repeticoes de cartas \n" +
                        "6 - sistema de trocas de cartas \n" +
                        "9 - Verificar regras do jogo \n" +
                        "0 - sair do programa.");
                op = leitorInt.nextInt();
                switch (op) {
                    case 1:
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
                                novaCriatura.adicionarCarta(novaCriatura, cartas);
                                break;
                            case "feitico":
                                //System.out.println("------ cadastro de cartas do tipo feitico ---------");
                                Feitico novoFeitico = new Feitico(nome, custo, raridade, tipo,0,0,1);
                                novoFeitico.adicionarCarta(novoFeitico, cartas);
                                break;
                            case "encantamento":
                                //System.out.println("------ cadastro de cartas do tipo encantamento ---------");
                                Encantamento novoEncantamento = new Encantamento(nome, custo, raridade, tipo,0,0,1);
                                novoEncantamento.adicionarCarta(novoEncantamento, cartas);
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("-----sistema de consultas------");

                        System.out.println("digite por qual sistema você deseja buscar (criatura, feitico, encantamento, valor do custo, raridade):");
                        String tipoConsulta = leitor.nextLine();

                        consultarCarta(tipoConsulta, cartas); //funcao de busca

                        break;

                    case 3:
                        listarCartas(cartas);
                        break;
                    case 4:
                        listarCartas(cartas);
                        System.out.println("essas são as cartas disponiveis, escolha o indice da carta que deseja realizar alguma acao: ");
                        Integer opcaoAcao = leitorInt.nextInt();

                        opcaoAcao --; // pequeno ajuste pq na hora de exibir, o valor do indice é incrementado

                        agirCarta(cartas.get(opcaoAcao));

                        break;
                    case 5:
                        verificarRepeticoes(cartas);//arrumar ordenacao
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

                        if(adicionarCarta1(nomeCarta1, custoCarta1, tipoCarta1, tipoCarta1, cartas, trocasCadastradas) && adicionarCarta2(nomeCarta2, custoCarta2, tipoCarta2, tipoCarta2, cartas, trocasCadastradas)){
                            System.out.println("A possibilidade de troca foi cadastrada!");
                        }else{
                            System.out.println("foi adicionada na troca uma carta não cadastrada.");
                        }

                        break;
                    case 9:
                        System.out.println("O JOGO DE CARTAS POSSUI AS SEGUINTES REGRAS: \n" +
                                "as trocas são efetuadas pelo valor dado a carta. \n");
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


    //--------------- FUNCOES UTILIZADAS ---------------//


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
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println( (i+1) + " -> "+ cartas.get(i).getTipo().toUpperCase(Locale.ROOT) +  cartas.get(i).toString() + "\n");
        }
    }

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

    public static void verificarRepeticoes(LinkedList<Cartas> cartas){
        ArrayList<Cartas> cartasRepetidas = new ArrayList<>();
        ArrayList<Cartas> cartasAux = new ArrayList<>();

        for(int i=0; i<cartas.size() ;i++) {
            cartasAux.add(cartas.get(i));
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

        System.out.println("No total, foram encontradas " + cartasRepetidas.size() + " cartas repetidas!\n");
        for(int i=0; i<cartasRepetidas.size(); i++){
                System.out.println((i+1) + " -> " + cartasRepetidas.get(i).toString() + " ");
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
