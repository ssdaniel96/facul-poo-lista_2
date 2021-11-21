import javax.swing.JOptionPane;

import classes.Robo;

public class App {
    public static void main(String[] args) throws Exception {
        Robo robo = new Robo();
        JOptionPane.showMessageDialog(null, String.format("Direção atual: %d", robo.getDirecao()));
        do {
            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite nova direção: "));
            robo.mudaDirecao(valor);
            JOptionPane.showMessageDialog(null, String.format("Direção atual: %d", robo.getDirecao()));
        } 
        while (JOptionPane.showConfirmDialog(null, "Deseja adicionar novas direções?", "Deseja continuar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
