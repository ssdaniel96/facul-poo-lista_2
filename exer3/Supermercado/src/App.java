import javax.swing.JOptionPane;

import Entidades.Supermercados.Supermercado;

public class App {
    public static void main(String[] args) throws Exception {
        Supermercado supermercado = new Supermercado();
        if (JOptionPane.showConfirmDialog(null, "Deseja preencher com itens prévios para testes?",
                "Preencher para testes", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            supermercado.AdicionarNovoProdutoAoEstoque("TV", 2000, 10);
            supermercado.AdicionarNovoProdutoAoEstoque("Rádio", 300, 3);
            supermercado.AdicionarNovoProdutoAoEstoque("Fogão", 850.30f, 2);
            supermercado.AdicionarNovoProdutoAoEstoque("Jogo de Xadrez", 200, 1);
        }
        ExecuteMenu(supermercado);
    }

    private static void ExecuteMenu(Supermercado supermercado) throws Exception {
        boolean executar = true;
        do {
            executar = chooseMenu(supermercado, chooseValidMenu(7, 0));
        } while (executar);
    }

    private static boolean chooseMenu(Supermercado supermercado, int option) throws Exception {
        switch (option) {
        case 1: // Visualizar estoque
            supermercado.VisualizarEstoque();
            break;
        case 2: // Adicionar novo produto ao estoque
            supermercado.AdicionarNovoProdutoAoEstoque();
            supermercado.VisualizarEstoque();
            break;
        case 3: // Remover produto do estoque
            supermercado.RemoverProdutoDoEstoque();
            supermercado.VisualizarEstoque();
            break;
        case 4: // visualizar carrinho
            supermercado.VisualizarCarrinho();
            break;
        case 5:
            supermercado.AdicionarItemNoCarrinho();
            supermercado.VisualizarCarrinho();
            break;
        case 6: // Remover produto do carrinho
            supermercado.RemoverItemDoCarrinho();
            supermercado.VisualizarCarrinho();
            break;
        case 7: // Processar venda
            supermercado.Vender();
            break;
        case 0: // sair
            if (supermercado.TemItemsNoCarrinho()) {
                return JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? Existem itens no carrinho!",
                        "Confirmação de Saída", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION;
            }
            return false;
        }

        return true;
    }

    private static int chooseValidMenu(int maxOptionMenu, int minOptionMenu) {
        int value = Integer
                .parseInt(JOptionPane.showInputDialog(null, getMenu(), "Menu", JOptionPane.QUESTION_MESSAGE));
        if (value < minOptionMenu || value > maxOptionMenu) {
            JOptionPane.showMessageDialog(null,
                    String.format("Você deve escolher valores entre %d e %d", minOptionMenu, maxOptionMenu),
                    "Valores inválidos", JOptionPane.WARNING_MESSAGE);
            value = chooseValidMenu(maxOptionMenu, minOptionMenu);
        }
        return value;
    }

    private static String getMenu() {
        String menu = "";
        menu += "1 - Visualizar estoque" + "\n";
        menu += "2 - Adicionar novo produto ao estoque" + "\n";
        menu += "3 - Remover produto do estoque" + "\n";
        menu += "4 - Visualizar Carrinho" + "\n";
        menu += "5 - Adicionar produto ao carrinho" + "\n";
        menu += "6 - Remover produto do carrinho" + "\n";
        menu += "7 - Processar venda" + "\n";
        menu += "0 - Sair" + "\n";
        return menu;
    }
}
