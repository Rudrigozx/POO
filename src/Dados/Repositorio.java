package Dados;

import Abstratas.ProdutoAbstrato;
import Basico.Produto;
import Excecoes.ProdutoJaCadastradoException;
import Excecoes.ProdutoNaoEncontradoException;

import java.io.*;
import java.util.ArrayList;

public class Repositorio implements Serializable {

    public ArrayList<ProdutoAbstrato> produtos;

   public Repositorio() {
         produtos = new ArrayList();

    }

    public void inserir(ProdutoAbstrato produto) throws ProdutoJaCadastradoException {
        Boolean adicionado = false;
        int posisao = -1;
        if (produtos.size() == 0) {
            produtos.add(produto);
            adicionado = true;
        } else {
            posisao = -1;

            try {
                posisao = procurar(produto.descricao);
            }catch (ProdutoNaoEncontradoException pne){
                pne.printStackTrace();
            }

            if (posisao >= 0) {
                throw new ProdutoJaCadastradoException();
            } else {
                produtos.add(produto);
                adicionado = true;
            }
        }
        if (adicionado == true) {
            System.out.println("cadastrado com sucesso");
        }

    }

    public int procurar(String procura) throws ProdutoNaoEncontradoException {
        int posicao = -1;

        for (ProdutoAbstrato produto : produtos) {
            if (produto.descricao.equals(procura)) {
                posicao = produtos.indexOf(produto);

                //  System.out.println("Produto encontrado:");
                System.out.println(produtos.get(posicao));
                break;

            }
        }
        if (posicao < 0) {
            throw new ProdutoNaoEncontradoException();
        }
        return posicao;
    }


    public void remover(String remove)  {
        int posicao;
        boolean removido = false;
        posicao = -1;
        try {
            posicao = procurar(remove);
        }catch (ProdutoNaoEncontradoException pne){
            pne.printStackTrace();
        }

        if (posicao >= 0) {
            produtos.remove(posicao);
            System.out.println("removido com sucesso!!!");
        } else {
            System.out.println("\nProduto a ser removido nao existe!!!\n");

        }


    }

    public void exibir(ArrayList produtos) {

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));

        }
    }

     public  void Salvar(Repositorio repositorioProduto) throws IOException {

        FileOutputStream file = new FileOutputStream("repositorio.dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(repositorioProduto);
        os.close();
}
    public Repositorio carregar() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("repositorio.dat");
        ObjectInputStream is = new ObjectInputStream(file);
        Repositorio repositorioProduto = (Repositorio) is.readObject();
        is.close();
        return repositorioProduto;
    }
}

