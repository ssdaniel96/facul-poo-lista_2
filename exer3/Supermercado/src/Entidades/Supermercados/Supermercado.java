package Entidades.Supermercados;

import javax.swing.JOptionPane;
import Entidades.Carrinhos.Carrinho;
import Entidades.Estoques.Estoque;
import Entidades.Produtos.Produto;

public class Supermercado {
    private Estoque estoque = new Estoque();
    private Carrinho carrinho = new Carrinho(); // pra o ex é suficiente fazer dessa forma

    public void AdicionarNovoProdutoAoEstoque(String nome, float preco, int quantidade) throws Exception {
        estoque.Adicionar(nome, preco, quantidade);
    }

    public void RemoverProdutoDoEstoque() throws Exception {
        int index = Integer
                .parseInt(JOptionPane.showInputDialog(null, estoque.toString() + "\nDigite o index que deseja remover",
                        "RemoverProduto", JOptionPane.QUESTION_MESSAGE))
                - 1;

        var item = estoque.getIndex(index);

        int quantidade = Integer
                .parseInt(JOptionPane.showInputDialog(
                        null, String.format("%s tem %d unidade(s), quantas deseja remover?",
                                item.getProduto().getNome(), item.getQuantidade()),
                        "Quantidade", JOptionPane.QUESTION_MESSAGE));

        try {
            estoque.Remover(index, quantidade);
        } catch (Exception e) {
            JOptionPane.showInputDialog(null,
                    "Tente novamente, ocorreu um erro ao tentar remover, você inseriu um index existente?", "Erro",
                    JOptionPane.WARNING_MESSAGE);

            RemoverProdutoDoEstoque();
            return;
        }

        JOptionPane.showMessageDialog(null,
                String.format("%d %s(s) retirados do estoque com sucesso", quantidade, item.getProduto().getNome()),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void AdicionarNovoProdutoAoEstoque() throws Exception {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto", "Nome",
                JOptionPane.QUESTION_MESSAGE);
        float preco = Float.parseFloat(
                JOptionPane.showInputDialog(null, "Digite o preço do produto", "Valor", JOptionPane.QUESTION_MESSAGE));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade a ser adicionada",
                "Quantidade", JOptionPane.QUESTION_MESSAGE));
        try {
            estoque.Adicionar(nome, preco, quantidade);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Um erro ocorreu", JOptionPane.WARNING_MESSAGE);
            AdicionarNovoProdutoAoEstoque();
        }
    }

    public void VisualizarEstoque() {
        JOptionPane.showMessageDialog(null, estoque.toString(), "Itens disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }

    public void VisualizarCarrinho() {
        JOptionPane.showMessageDialog(null, carrinho.toString(), "Itens no carrinho", JOptionPane.INFORMATION_MESSAGE);
    }

    public void AdicionarItemNoCarrinho() throws Exception {
        int index = Integer.parseInt(JOptionPane.showInputDialog(null,
                estoque.toString() + "\nDigite o index do produto que deseja adicionar", "RemoverProduto",
                JOptionPane.QUESTION_MESSAGE)) - 1;

        var item = estoque.getIndex(index);

        int quantidade = Integer
                .parseInt(JOptionPane.showInputDialog(
                        null, String.format("%s tem %d unidade(s), quantas deseja adicionar?",
                                item.getProduto().getNome(), item.getQuantidade()),
                        "Quantidade", JOptionPane.QUESTION_MESSAGE));

        // TODO: validação
        carrinho.Adicionar(item.getProduto(), quantidade);
        estoque.Remover(index, quantidade);

        JOptionPane.showMessageDialog(null,
                String.format("%d %s(s) adicionados ao carrinho com sucesso", quantidade, item.getProduto().getNome()),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void RemoverItemDoCarrinho() throws Exception {
        int index = Integer.parseInt(JOptionPane.showInputDialog(null,
                carrinho.toString() + "\nDigite o index do produto que deseja remover", "RemoverProduto",
                JOptionPane.QUESTION_MESSAGE)) - 1;
        var item = carrinho.getIndex(index);

        int quantidade = Integer
                .parseInt(JOptionPane.showInputDialog(
                        null, String.format("%s tem %d unidade(s), quantas deseja remover?",
                                item.getProduto().getNome(), item.getQuantidade()),
                        "Quantidade", JOptionPane.QUESTION_MESSAGE));

        // TODO: validação
        Produto prod = item.getProduto();
        carrinho.Remover(prod, quantidade);
        estoque.Adicionar(prod.getNome(), prod.getValor(), quantidade);

        JOptionPane.showMessageDialog(null,
                String.format("%d %s(s) removidos do carrinho com sucesso", quantidade, prod.getNome()), "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void Vender() {
        String message = String.format("Sua compra deu %.2f\nQual a forma de pagamento?\n", carrinho.getValorTotal());
        String fPagamentos = "1 - Cartão\n2 - Dinheiro\n3 - Cheque\n";
        message += fPagamentos;
        int value = Integer.parseInt(JOptionPane.showInputDialog(null, message, "Forma de pagamento", JOptionPane.INFORMATION_MESSAGE));
        if (value < 0 || value > 3){
            JOptionPane.showMessageDialog(null, "Forma de pagamento inválida", "Erro", JOptionPane.WARNING_MESSAGE);
            Vender();
            return;
        }

        JOptionPane.showMessageDialog(null, carrinho.toString(), "Sumário da venda", JOptionPane.INFORMATION_MESSAGE);
        carrinho = new Carrinho();
        JOptionPane.showMessageDialog(null, "Carrinho pronto para novos usos!", "Obrigado por fazer negócios conosco", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean TemItemsNoCarrinho(){
        return carrinho.getValorTotal() > 0;
    }

}
