import javax.swing.JOptionPane;

import classes.Fatura;

public class App {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Criando fatura...");
        Fatura fatura = new Fatura(1, "Pocossauro", 2, 200);
        fatura.Print(); //aqui ele tá chamando o método de calcular total da fatura
        JOptionPane.showMessageDialog(null, "Alterando quantidade para 5...");
        fatura.setQuantidade(5);
        fatura.Print();
        JOptionPane.showMessageDialog(null, "Alterando valor para -200");
        fatura.setPreco(-200);
        fatura.Print();

        
    }
}
