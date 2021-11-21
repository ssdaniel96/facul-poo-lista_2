package Entidades.Carrinhos;

import java.util.ArrayList;

import Entidades.Produtos.Produto;

public class Carrinho {
    private ArrayList<CarrinhoItem> items = new ArrayList<CarrinhoItem>();

    
    public CarrinhoItem getIndex(int index){
        return items.get(index);
    }

    public float getValorTotal() {
        float valorTotal = 0f;
        for (CarrinhoItem carrinhoItem : items) {
            valorTotal += carrinhoItem.getValorTotal();
        }
        return valorTotal;
    }

    @Override
    public String toString(){
        String msg = "";
        Float valorTotal = 0f;
        for (CarrinhoItem item : items) {
            msg += Integer.toString((items.indexOf(item)+1)) + " - " + item.toString() + "\n";
            valorTotal += item.getValorTotal();
        }
        msg += String.format("Valor total: R$ %.2f\n", valorTotal);
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

}
