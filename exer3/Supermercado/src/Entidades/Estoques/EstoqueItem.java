package Entidades.Estoques;

import Entidades.Produtos.Produto;

public class EstoqueItem {
    private Produto produto;
    private int quantidade;
    
    @Override
    public String toString(){
        return String.format("%s - R$ %.2f (%d)", produto.getNome(), produto.getValor(), quantidade);
    }

    public EstoqueItem(Produto produto, int quantidade) throws Exception {
        setProduto(produto);
        setQuantidade(quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public void RetirarDoEstoque(int quantidade) throws Exception{
        if (quantidade <= 0){
            throw new Exception("Não pode remover produtos do estoque com quantidades menores ou iguais a 0");
        }
        this.quantidade -= quantidade;
    }

    public void AdicionarAoEstoque(int quantidade) throws Exception{
        if (quantidade <= 0){
            throw new Exception("Não pode adicionar produtos ao estoque com quantidades menores ou iguais a 0");
        }
        this.quantidade += quantidade;
    }

    private void setProduto(Produto produto) throws Exception {
        if (produto == null){
            throw new Exception("Produto não pode ser nulo!");
        }
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(int quantidade) throws Exception {
        if (quantidade <= 0){
            throw new Exception("Não pode adicionar produtos ao estoque com quantidades menores ou iguais a 0");
        }

        this.quantidade = quantidade;
    }
}
