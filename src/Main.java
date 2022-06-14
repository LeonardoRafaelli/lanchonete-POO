import Exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Lanche> listaLanches = new ArrayList<>();
    static ArrayList<Bebida> listaBebidas = new ArrayList<>();
    static ArrayList<Outro> listaOutros = new ArrayList<>();

    public static void main(String[] args) {
        addLanchesEstaticos();

        try{
            menu();
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private static void menu() throws RuntimeException {
        int opcao = selecionaOpcao();
        if(opcao < 1 || opcao > 5){
            throw new OpcaoInvalidaException();
        }
        switch (opcao){
            case 1 -> cadastrar();
            case 2 -> listar();
            case 3 -> editar();
            case 4 -> remover();
            case 5 -> {
                System.out.println("Programa encerrado!");
                System.exit(0);
            }
        }
        menu();
    }

    private static void editar()  throws RuntimeException {
        int tipo = selecionaTipo("---EDITAR PREÇO---");
        int i = verificaCodigo(tipo);

        switch (tipo){
            case 1 -> {
                double precoAntigo = listaLanches.get(i).getPreco();

                System.out.println(listaLanches.get(i).toString());
                System.out.print("Digite o novo preço: ");
                double preco = sc.nextInt();
                listaLanches.get(i).setPreco(preco);

                System.out.println(listaLanches.get(i).toString());
                int alter = 1;
                do {
                    if(alter < 1 || alter > 2){
                        System.out.println("Escolha inválida!");
                    }
                    System.out.print("Confirmar alteração? (1 - sim) (2 - não): ");
                    alter = sc.nextInt();
                } while(alter < 1 || alter > 2);
                if(alter == 1){
                    System.out.println("Alteração feita com sucesso!");
                } else {
                    listaLanches.get(i).setPreco(precoAntigo);
                    System.out.println("Alteração cancelada!");
                }
            }
            case 2 -> {
                double precoAntigo = listaBebidas.get(i).getPreco();

                System.out.println(listaBebidas.get(i).toString());
                System.out.print("Digite o novo preço: ");
                double preco = sc.nextInt();
                listaBebidas.get(i).setPreco(preco);

                System.out.println(listaBebidas.get(i).toString());
                int alter = 1;
                do {
                    if(alter < 1 || alter > 2){
                        System.out.println("Escolha inválida!");
                    }
                    System.out.print("Confirmar alteração? (1 - sim) (2 - não): ");
                    alter = sc.nextInt();
                } while(alter < 1 || alter > 2);
                if(alter == 1){
                    System.out.println("Alteração feita com sucesso!");
                } else {
                    listaBebidas.get(i).setPreco(precoAntigo);
                    System.out.println("Alteração cancelada!");
                }
            }
            case 3 -> {
                double precoAntigo = listaOutros.get(i).getPreco();

                System.out.println(listaOutros.get(i).toString());
                System.out.print("Digite o novo preço: ");
                double preco = sc.nextInt();
                listaOutros.get(i).setPreco(preco);

                System.out.println(listaOutros.get(i).toString());
                int alter = 1;
                do {
                    if(alter < 1 || alter > 2){
                        System.out.println("Escolha inválida!");
                    }
                    System.out.print("Confirmar alteração? (1 - sim) (2 - não): ");
                    alter = sc.nextInt();
                } while(alter < 1 || alter > 2);
                if(alter == 1){
                    System.out.println("Alteração feita com sucesso!");
                } else {
                    listaOutros.get(i).setPreco(precoAntigo);
                    System.out.println("Alteração cancelada!");
                }
            }
        }
    }

    private static void remover() throws RuntimeException {
        int tipo = selecionaTipo("---REMOVER---");
        int i = verificaCodigo(tipo);
        int escolha = 1;
        switch (tipo){
            case 1 -> {
                do {
                    if(escolha < 1 || escolha > 2){
                        System.out.println("Escolha inválida! ");
                    }
                    System.out.print("\n"+listaLanches.get(i).toString() + "\nDeseja remover este lanche? (1 - sim) (2 - não): ");
                    escolha = sc.nextInt();
                } while (escolha < 1 || escolha > 2);

                if(escolha == 1){
                    listaLanches.remove(i);
                    System.out.println("Lanche removido!");
                } else {
                    System.out.println("Remoção do lanche cancelada!");
                }
            }
            case 2 -> {
                do {
                    if(escolha < 1 || escolha > 2){
                        System.out.println("Escolha inválida! ");
                    }
                    System.out.print("\n"+listaBebidas.get(i).toString() + "\nDeseja remover esta bebida? (1 - sim) (2 - não): ");
                    escolha = sc.nextInt();
                } while (escolha < 1 || escolha > 2);

                if(escolha == 1){
                    listaBebidas.remove(i);
                    System.out.println("Bebida removida!");
                } else {
                    System.out.println("Remoção da bebida cancelada!");
                }
            }
            case 3 -> {
                do {
                    if(escolha < 1 || escolha > 2){
                        System.out.println("Escolha inválida! ");
                    }
                    System.out.print("\n"+listaOutros.get(i).toString() + "\nDeseja remover este outro? (1 - sim) (2 - não): ");
                    escolha = sc.nextInt();
                } while (escolha < 1 || escolha > 2);

                if(escolha == 1){
                    listaOutros.remove(i);
                    System.out.println("Outro removido!");
                } else {
                    System.out.println("Remoção de outro cancelada!");
                }
            }
        }
    }

    private static int verificaCodigo(int tipo) throws RuntimeException{
        int i = 0;
        int cod;
        do {
            if(i == -1){
                throw new ProdutoInvalidoException();
            }
            switch (tipo){
                case 1 -> System.out.print("Digite o código do lanche: ");
                case 2 -> System.out.print("Digite o código da bebida: ");
                case 3 -> System.out.print("Digite o código do outro: ");
            }
            cod = sc.nextInt();
            i = coletaIndice(tipo, cod);
        } while (i == -1);
        if(i == -2){
            System.out.println("Não há cadastros!!");
            menu();
        }
        return i;
    }

    private static int coletaIndice(int tipo, int cod){
        switch (tipo){
            case 1 -> {
                if(listaLanches.size() == 0){
                    return -2;
                }
                for(int i = 0; i < listaLanches.size(); i++){
                    if (listaLanches.get(i).getCodigo() == cod){
                        return i;
                    }
                }
            }
            case 2 -> {
                if(listaBebidas.size() == 0){
                    return -2;
                }
                for(int i = 0; i < listaBebidas.size(); i++){
                    if(listaBebidas.get(i).getCodigo() == cod){
                        return i;
                    }
                }
            }
            case 3 -> {
                if(listaOutros.size() == 0){
                    return -2;
                }
                for (int i = 0; i < listaOutros.size(); i++){
                    if(listaOutros.get(i).getCodigo() == cod){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private static void listar(){
        int tipo = selecionaTipo("---LISTAR---");
        switch (tipo){
            case 1 -> {
                System.out.println("\nLANCHES: ");
                for (Lanche lan : listaLanches){
                    System.out.println(lan.toString());
                }
            }
            case 2 -> {
                System.out.println("\nBEBIDAS: ");
                for (Bebida beb : listaBebidas){
                    System.out.println(beb.toString());
                }
            }
            case 3 -> {
                System.out.println("\nOUTROS: ");
                for (Outro out : listaOutros){
                    System.out.println(out.toString());
                }
            }
        }
    }

    private static void cadastrar() throws RuntimeException{
        int tipo = selecionaTipo("---CADASTRAR---");
        switch (tipo){
            case 1 -> {
                Pedido p = coletaDadosPedido();
                Lanche lan = coletaDadosLanche(p);

                if(valida(tipo, lan.getCodigo())){
                    System.out.print("\n"+lan + "\nDeseja adicionar este lanche? (1 - sim) (2 - não): ");
                    int escolha = 1;

                    do {
                        if(escolha < 1 || escolha > 2){
                            System.out.println("Escolha inválida, digite (1 - sim) (2 - não): ");
                        }
                        escolha = sc.nextInt();
                    } while (escolha < 1 || escolha > 2);

                    if(escolha == 1){
                        listaLanches.add(lan);
                        System.out.println("Lanche adicionado!");
                    } else {
                        System.out.println("O lanche não foi adicionado!");
                    }
                } else {
                    throw new ProdutoExistenteException(tipo);
                }
            }
            case 2 -> {
                Pedido p = coletaDadosPedido();
                Bebida beb = coletaDadosBebida(p);

                if(valida(tipo, beb.getCodigo())){
                    System.out.print("\n"+beb + "\nDeseja adicionar esta bebida? (1 - sim) (2 - não): ");
                    int escolha = 1;

                    do {
                        if(escolha < 1 || escolha > 2){
                            System.out.println("Escolha inválida, digite (1 - sim) (2 - não): ");
                        }
                        escolha = sc.nextInt();
                    } while (escolha < 1 || escolha > 2);

                    if(escolha == 1){
                        listaBebidas.add(beb);
                        System.out.println("Bebida adicionada!");
                    } else {
                        System.out.println("A bebida não foi adicionada!");
                    }
                } else {
                    throw new ProdutoExistenteException(tipo);
                }
            }
            case 3 -> {
                Pedido p = coletaDadosPedido();
                Outro out = coletaDadosOutro(p);

                if(valida(tipo, out.getCodigo())){
                    System.out.print("\n"+out + "\nDeseja adicionar este outro? (1 - sim) (2 - não): ");
                    int escolha = 1;

                    do {
                        if(escolha < 1 || escolha > 2){
                            System.out.println("Escolha inválida, digite (1 - sim) (2 - não): ");
                        }
                        escolha = sc.nextInt();
                    } while (escolha < 1 || escolha > 2);

                    if(escolha == 1){
                        listaOutros.add(out);
                        System.out.println("Outro adicionado!");
                    } else {
                        System.out.println("Outro não foi adicionado!");
                    }
                } else {
                    throw new ProdutoExistenteException(tipo);
                }
            }
        }
    }

    private static int selecionaTipo(String titulo){
        int decisao;
        do {
            System.out.print("\n"+titulo+
                    "\n1 - Lanche;" +
                    "\n2 - Bebida;" +
                    "\n3 - Outro;" +
                    "\n4 - Voltar;" +
                    "\nDigite aqui: ");
            decisao = sc.nextInt();
            if(decisao == 4){
                menu();
            }
        } while (decisao < 1 || decisao > 3);
        return decisao;
    }

    private static int selecionaOpcao(){
        int decisao;
        do {
            System.out.print("""
                                        
                    ---MENU---
                    1 - Cadastrar;
                    2 - Listar;
                    3 - Editar;
                    4 - Remover;
                    5 - Encerrar.
                    Digite aqui:\s""");
            decisao = sc.nextInt();
        } while (decisao < 1 || decisao > 5);
        return decisao;
    }

    private static boolean valida(int tipo, int codigo){
        switch (tipo){
            case 1 -> {
                for(Lanche lanche : listaLanches){
                    if(lanche.getCodigo() == codigo){
                        return false;
                    }
                }
            }
            case 2 -> {
                for (Bebida bebida : listaBebidas) {
                    if (bebida.getCodigo() == codigo) {
                        return false;
                    }
                }
            }
            case 3 -> {
                for(Outro outro : listaOutros){
                    if(outro.getCodigo() == codigo){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static Pedido coletaDadosPedido() throws RuntimeException{
        System.out.println("\nInsira os seguintes dados: ");
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        System.out.print("Descrição: ");
        String descricao = sc.next();
        System.out.print("Preço (R$): ");
        double preco = sc.nextDouble();
        if(preco < 0 || preco > 200){
            throw new PrecoInvalidoException();
        }
        return new Pedido(codigo, descricao, preco);
    }

    private static Lanche coletaDadosLanche(Pedido pedido) throws RuntimeException{
        System.out.print("Peso (Kg): ");
        double peso = sc.nextInt();
        if(peso < 0 || peso > 10){
            throw new PesoInvalidoException();
        }
        return new Lanche(pedido.getCodigo(), pedido.getDescricao(), pedido.getPreco(), peso);
    }

    private static Bebida coletaDadosBebida(Pedido pedido) throws RuntimeException{
        Bebida bebida = new Bebida();
        System.out.print("Litros: ");
        double litros = sc.nextDouble();
        if(litros < 0 || litros > 10){
            throw new VolumeInvalidoException();
        }
        bebida.setVolume(litros);
        bebida.setCodigo(pedido.getCodigo());
        bebida.setDescricao(pedido.getDescricao());
        bebida.setPreco(pedido.getPreco());
        return bebida;
    }

    private static Outro coletaDadosOutro(Pedido pedido) throws RuntimeException{
        Outro outro = new Outro();
        System.out.print("Tamanho: ");
        String tamanho = sc.next();
        if(tamanho.equals("P") || tamanho.equals("M") || tamanho.equals("G")){
            outro.setTamanho(tamanho);
        } else {
            throw new TamanhoInvalidoException();
        }
        outro.setCodigo(pedido.getCodigo());
        outro.setDescricao(pedido.getDescricao());
        outro.setPreco(pedido.getPreco());
        return outro;
    }

    private static void addLanchesEstaticos(){
        listaLanches.add(new Lanche(1, "X-Salada", 12, 0.8));
        listaLanches.add(new Lanche(2, "X-Tudo", 18, 1.2));
        listaLanches.add(new Lanche(3, "X-Burger", 10, 0.6));
        listaLanches.add(new Lanche(4, "X-Bacon", 15, 1.0));
        Bebida bebida1 = new Bebida();
        bebida1.setCodigo(1);
        bebida1.setDescricao("Refrigerante");
        bebida1.setPreco(5);
        bebida1.setVolume(0.35);
        Bebida bebida2 = new Bebida();
        bebida2.setCodigo(2);
        bebida2.setDescricao("Refrigerante");
        bebida2.setPreco(10);
        bebida2.setVolume(0.6);
        Bebida bebida3 = new Bebida();
        bebida3.setCodigo(3);
        bebida3.setDescricao("Suco");
        bebida3.setPreco(6);
        bebida3.setVolume(0.35);
        Bebida bebida4 = new Bebida();
        bebida4.setCodigo(4);
        bebida4.setDescricao("Suco");
        bebida4.setPreco(12);
        bebida4.setVolume(0.6);
        listaBebidas.add(bebida1);
        listaBebidas.add(bebida2);
        listaBebidas.add(bebida3);
        listaBebidas.add(bebida4);
        Outro outro1 = new Outro();
        outro1.setCodigo(1);
        outro1.setDescricao("Batata Frita");
        outro1.setPreco(5);
        outro1.setTamanho("Pequena");
        Outro outro2 = new Outro();
        outro2.setCodigo(2);
        outro2.setDescricao("Batata Frita");
        outro2.setPreco(12.5);
        outro2.setTamanho("Média");
        Outro outro3 = new Outro();
        outro3.setCodigo(3);
        outro3.setDescricao("Batata Frita");
        outro3.setPreco(20);
        outro3.setTamanho("Grande");
        Outro outro4 = new Outro();
        outro4.setCodigo(4);
        outro4.setDescricao("Salada");
        outro4.setPreco(8);
        outro4.setTamanho("Média");
        listaOutros.add(outro1);
        listaOutros.add(outro2);
        listaOutros.add(outro3);
        listaOutros.add(outro4);
    }
}