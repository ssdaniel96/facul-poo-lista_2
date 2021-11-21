package Entidades.Supermercados;

import javax.swing.JOptionPane;

import Entidades.Carrinhos.Carrinho;
import Entidades.Estoques.Estoque;
import Enums.FormaPagamentoEnum;

public class Supermercado {
    private Estoque estoque = new Estoque();

    public  void AdicionarNovoProdutoAoEstoque(String nome, float preco, int quantidade) throws Exception{
        estoque.Adicionar(nome, preco, quantidade);
    }

    public void RemoverProdutoDoEstoque() throws Exception{
        int index = Integer.parseInt(
            JOptionPane.showInputDialog(
                null, 
                estoque.toString() + "\nDigite o index que deseja remover", 
                "RemoverProduto", 
                JOptionPane.QUESTION_MESSAGE)) - 1;

        var item = estoque.getIndex(index);

        int quantidade = Integer.parseInt(
            JOptionPane.showInputDialog(
                null, 
                String.format("%s tem %d unidade(s), quantas deseja remover?", item.getProduto().getNome(), item.getQuantidade()), 
                "Quantidade", 
                JOptionPane.QUESTION_MESSAGE));

        try {
            estoque.Remover(index, quantidade);
        }
        catch (Exception e){
            JOptionPane.showInputDialog(
                null, 
                "Tente novamente, ocorreu um erro ao tentar remover, você inseriu um index existente?", 
                "Erro", 
                JOptionPane.WARNING_MESSAGE);

            RemoverProdutoDoEstoque();
            return;
        }

        JOptionPane.showMessageDialog(
            null, 
            String.format("%d %s(s) retirados do estoque com sucesso", quantidade, item.getProduto().getNome()), 
            "Sucesso", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    public  void AdicionarNovoProdutoAoEstoque() throws Exception{
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto", "Nome", JOptionPane.QUESTION_MESSAGE);
        float preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preço do produto", "Valor", JOptionPane.QUESTION_MESSAGE));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade a ser adicionada", "Quantidade", JOptionPane.QUESTION_MESSAGE));
        try {
            estoque.Adicionar(nome, preco, quantidade);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Um erro ocorreu", JOptionPane.WARNING_MESSAGE);
            AdicionarNovoProdutoAoEstoque();
        }
    }

    public float Vender(Carrinho carrinho, FormaPagamentoEnum formaPagamento) throws Exception {
        return carrinho.ProcessarCarrinho(estoque);
    }

    public void VisualizarEstoque() {
        JOptionPane.showMessageDialog(null, estoque.toString(), "Itens disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }

    public void VisualizarCarrinho(Carrinho carrinho){
        JOptionPane.showMessageDialog(
            null, carrinho., title, messageType);
    }
}
