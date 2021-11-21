package Entidades.Carrinhos;

import java.util.ArrayList;

import Entidades.Estoques.Estoque;
import Entidades.Produtos.Produto;

public class Carrinho {
    private ArrayList<CarrinhoItem> items = new ArrayList<CarrinhoItem>();

    @Override
    public String toString(){
        String msg = "";
        for (CarrinhoItem item : items) {
            msg += Integer.toString((items.indexOf(item)+1)) + " - " + item.toString() + "\n";
        }
        return msg;
    }

    public void Adicionar(Produto produto, int quantidade) throws Exception {
        CarrinhoItem item = buscarProduto(produto);
        if (item == null) {
            items.add(new CarrinhoItem(produto, quantidade));
        } else {
            item.Adicionar(quantidade);
        }
    }

    public void Remover(Produto produto, int quantidade) throws Exception {
        Remover(produto.getNome(), quantidade);
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

        if (item.getQuantidade() == quantidade) {
            items.remove(item);
        } else {
            item.Retirar(quantidade);
        }
    }

    private CarrinhoItem buscarProduto(Produto produto) {
        return buscarProduto(produto.getNome());
    }

    private CarrinhoItem buscarProduto(String nome) {
        for (CarrinhoItem item : items) {
            if (item.getProduto().getNome().equals(nome)) {
                return item;
            }
        }
        return null;
    }

    public float ProcessarCarrinho(Estoque estoque) throws Exception {
        float valorTotal = 0;
        for (CarrinhoItem item : items) {
            estoque.Remover(item.getProduto().getNome(), item.getQuantidade());
            valorTotal += item.getProduto().getValor() * item.getQuantidade();
        }
        return valorTotal;
    }
}
