package Entidades.Carrinhos;

import Entidades.Produtos.Produto;

public class CarrinhoItem {
    private Produto produto;
    private int quantidade;
    
    public CarrinhoItem(Produto produto, int quantidade) throws Exception {
        setProduto(produto);
        setQuantidade(quantidade);
    }

    @Override
    public String toString(){
        return String.format("%s - Valor Un. %.2f - Total: %.2f (%d)", produto.getNome(), produto.getValor(), quantidade * produto.getValor(), quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public float getValorTotal(){
        return quantidade * produto.getValor();
    }

    public void Retirar(int quantidade) throws Exception{
        if (quantidade <= 0){
            throw new Exception("Não pode remover produtos do carrinho com quantidades menores ou iguais a 0");
        }
        this.quantidade -= quantidade;
    }

    public void Adicionar(int quantidade) throws Exception{
        if (quantidade <= 0){
            throw new Exception("Não pode adicionar produtos ao carrinho com quantidades menores ou iguais a 0");
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
            throw new Exception("Não pode adicionar produtos ao carrinho com quantidades menores ou iguais a 0");
        }

        this.quantidade = quantidade;
    }
}
