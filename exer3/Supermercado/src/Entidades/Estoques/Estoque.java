package Entidades.Estoques;

import java.util.ArrayList;

import Entidades.Produtos.Produto;

public class Estoque {
    private ArrayList<EstoqueItem> items = new ArrayList<EstoqueItem>();

    public void Adicionar(String nome, float valor, int quantidade) throws Exception {
        EstoqueItem item = buscarProduto(nome);
        if (item == null) {
            Produto produto = new Produto(nome, valor);
            items.add(new EstoqueItem(produto, quantidade));
        } else {
            if (item.getProduto().getValor() != valor) {
                throw new Exception(
                        "Já existe um produto no estoque com esse nome mas com valor diferente, altere o nome para poder adicionar");
            }

            item.AdicionarAoEstoque(quantidade);
        }
    }

    public void Remover(String nome, int quantidade) throws Exception {
        var item = buscarProduto(nome);
        if (item == null) {
            throw new Exception("Não existe esse produto para retirar do estoque");
        }
        if (item.getQuantidade() < quantidade) {
            throw new Exception(
                    String.format("Quantidade atual que existe em estoque (%d) é inferior a quantidade requerida (%d)",
                            item.getQuantidade(), quantidade));
        }

        if (item.getQuantidade() == quantidade){
            items.remove(item);
        }
        else{
            item.RetirarDoEstoque(quantidade);
        }
    }

    private EstoqueItem buscarProduto(String nome) {
        for (EstoqueItem item : items) {
            if (item.getProduto().getNome().equals(nome)) {
                return item;
            }
        }
        return null;
    }

}
