package Entidades.Supermercados;

import Entidades.Carrinhos.Carrinho;
import Entidades.Estoques.Estoque;
import Enums.FormaPagamentoEnum;

public class Supermercado {
    private Estoque estoque = new Estoque();

    public  void AdicionarNovoProdutoAoEstoque(String nome, float preco, int quantidade) throws Exception{
        estoque.Adicionar(nome, preco, quantidade);
    }

    public void Vender(Carrinho carrinho, FormaPagamentoEnum formaPagamento){

    }
}
