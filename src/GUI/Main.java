package GUI;

import Basico.Smartphone;
import Basico.Especificacao;
import Basico.Produto;
import Dados.Repositorio;
import Excecoes.LimiteAtingidoException;
import Excecoes.ProdutoJaCadastradoException;
import Excecoes.ProdutoNaoEncontradoException;
import Excecoes.QuantidadeInsuficienteException;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Repositorio repositorioProduto = new Repositorio();
        try {
            repositorioProduto = repositorioProduto.carregar();
        }catch (IOException io){
            io.printStackTrace();
        }



        Scanner sc=new Scanner(System.in);
        boolean sair = false;


    while(!sair){
        String descricao;
        int quantidade,limiteEstoque,adicionar,remover;
        double preco;

        System.out.println("\t========= Menu ==========\n" +
                "\t#  1- Cadastrar \n" +
                "\t#  2- Procurar \n" +
                "\t#  3- Exibir \n" +
                "\t#  4- Remover \n" +
                "\t#  5- Adicionar Quantidade\n" +
                "\t#  6- Remover Quantidade\n" +
                "\t#  7- lucro Bruto\n" +
                "\t#  99- Sair e Salvar\n\n" +
                "Digite uma opcao: ");

        int opcao = Integer.parseInt(sc.nextLine());


        switch (opcao){


            case 1:
                System.out.println("Este produto é um eletronico?(S/N) ");
                String resposta = sc.nextLine();
                if (resposta.equals("N")) {
                    System.out.println("\n=========== Cadastro ==============\n");
                    System.out.flush();
                    System.out.println("Digite a descricao do produto: ");
                    descricao = sc.nextLine();

                    System.out.println("Digite a quantidade do produto: ");
                    quantidade = Integer.parseInt(sc.nextLine());

                    System.out.println("Digite o preco do produto: ");
                    preco = Double.parseDouble(sc.nextLine());

                    System.out.println("Digite o limite de Estoque do produto: ");
                    limiteEstoque = Integer.parseInt(sc.nextLine());

                    Produto produto = new Produto(preco, descricao, quantidade, limiteEstoque);

                    try {
                        repositorioProduto.inserir(produto);
                    } catch (ProdutoJaCadastradoException pjc) {
                        pjc.printStackTrace();
                    }


                    System.out.println("\n============================\n");
                }else {

                    System.out.println("\n=========== Cadastro de Smartphone ==============\n");

                    System.out.println("Digite a descricao do produto: ");
                    descricao = sc.nextLine();

                    System.out.println("Digite a quantidade do produto: ");
                    quantidade =  Integer.parseInt(sc.nextLine());

                    System.out.println("Digite o preco do produto: ");
                    preco =  Double.parseDouble(sc.nextLine());

                    System.out.println("Digite o armazenamento: ");
                    String armazenamento = sc.nextLine();

                    System.out.println("Digite a memoria ram: ");
                    String ram = sc.nextLine();

                    System.out.println("Digite o tamanho da bateria: ");
                    String bateria = sc.nextLine();

                    Especificacao especificacao = new Especificacao(armazenamento,ram,bateria);
                    Smartphone smartphone = new Smartphone(preco, descricao, quantidade,especificacao );

                    try {
                        repositorioProduto.inserir(smartphone);
                    } catch (ProdutoJaCadastradoException pjc) {
                        pjc.printStackTrace();
                    }


                    System.out.println("\n============================\n");
                }
                break;

            case 2:
                System.out.println("\n============ Procurar ===========\n");
                System.out.println("Digite a descricao do produto: ");
                descricao = sc.next();
                try {
                    repositorioProduto.procurar(descricao);
                }catch (ProdutoNaoEncontradoException pne){
                    pne.printStackTrace();
                }
                System.out.println("\n============================\n");
                break;
            case 3:
                System.out.println("\n============= Exibir ============\n");
                repositorioProduto.exibir(repositorioProduto.produtos);
                System.out.println("\n============================\n");
                break;
            case 4:
                System.out.println("\n=========== Remover ===========\n");
                System.out.println("Digite a descricao do produto: ");
                descricao = sc.next();
                repositorioProduto.remover(descricao);
                System.out.println("\n============================\n");
                break;

            case 5:
                System.out.println("\n=========== Adicionar Quantidade ============\n");
                System.out.println("Digite a descricao do produto: ");
                descricao = sc.next();
                int p=-1;
                try {
                    p = repositorioProduto.procurar(descricao);
                }catch (ProdutoNaoEncontradoException pne){
                    pne.printStackTrace();
                }
                System.out.println("Digite a quantidade a adicionar do produto: ");
                adicionar = sc.nextInt();
                try {
                    repositorioProduto.produtos.get(p).adicionarProduto(adicionar);
                }catch (LimiteAtingidoException lae){
                    lae.printStackTrace();
                }
                System.out.println("\n============================\n");
                break;

            case 6:
                System.out.println("\n============ Remover Quantidade ================\n");
                System.out.println("Digite a descricao do produto: ");
                descricao = sc.next();
                int po =-1;
                try {
                   po = repositorioProduto.procurar(descricao);
                }catch (ProdutoNaoEncontradoException pne){
                    pne.printStackTrace();
                }
                System.out.println("Digite a quantidade a remover do produto: ");
                remover = sc.nextInt();
                try {
                    repositorioProduto.produtos.get(po).removerProduto(remover);
                }catch (QuantidadeInsuficienteException qie){
                    qie.printStackTrace();
                }
                System.out.println("\n============================\n");
                break;

            case 7:
                System.out.println("\n============ Lucro Bruto ================\n");
                System.out.println("Digite a descricao do produto: ");
                descricao = sc.next();
                p=-1;
                try {
                    p = repositorioProduto.procurar(descricao);
                }catch (ProdutoNaoEncontradoException pne){
                    pne.printStackTrace();
                }

                System.out.println("lucro bruto: "+repositorioProduto.produtos.get(p).lucroBruto());
                break;






            case 99:
                System.out.println("\n============================\n");
                System.out.println("Volte sempre!!!!");
                repositorioProduto.Salvar(repositorioProduto);
                sair=true;
                System.out.println("\n============================\n");
                break;


            default:
                System.out.println("\n============================\n");
                System.out.println("opcao invalida!!!");
                System.out.println("\n============================\n");
                break;

        }
    }

    }

}
