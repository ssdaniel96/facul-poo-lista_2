package Entidades.Carrinhos;

import java.util.ArrayList;

import Entidades.Produtos.Produto;

public class Carrinho {
    private ArrayList<CarrinhoItem> items = new ArrayList<CarrinhoItem>();

    public void Adicionar(Produto produto, int quantidade) throws Exception {
        CarrinhoItem item = buscarProduto(nome);
        if (item == null) {
            items.add(new CarrinhoItem(produto, quantidade))    
        } else {
            item.Adicionar(quantidade);
        }
    }

    public void Remover(String nome, int quantidade) throws Exception {
        var item = buscarProduto(nome);
        if (item == null) {
            throw new Exception("Não existe esse produto para retirar do estoque");
        }
        if (item.getQuantidade() < quantidade) {
            throw new Exception(
                    String.format("Quantidade atual que existe no carrinho (%d) é inferior a quantidade requerida (%d)",
                            item.getQuantidade(), quantidade));
        }

        if (item.getQuantidade() == quantidade){
            items.remove(item);
        }
        else{
            item.Retirar(quantidade);
        }
    }

    private CarrinhoItem buscarProduto(String nome) {
        for (CarrinhoItem item : items) {
            if (item.getProduto().getNome().equals(nome)) {
                return item;
            }
        }
        return null;
    }
}
