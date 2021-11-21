import java.util.Random;

import javax.swing.JOptionPane;

import classes.Circulo;
import classes.Forma;
import classes.Quadrado;
import classes.Retangulo;

public class App {
    public static void main(String[] args) throws Exception {
        Random rd = new Random();

        JOptionPane.showMessageDialog(null, "Instanciando e inicializando array com espaço para cinco formas...");
        Forma[] formas = new Forma[5];

        JOptionPane.showMessageDialog(null, "Gerando formas e valores...");
        for (int i = 0; i < 5; i++) {
            formas[i] = GenerateForma(rd);
        }

        int posicao = 1;
        for (Forma forma : formas) {
            JOptionPane
                    .showMessageDialog(null,
                            String.format("%d\nArea: %.2f\nPerimetro: %.2f", posicao, forma.calcularArea(),
                                    forma.calcularPerimetro()),
                            forma.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
            posicao++;
        }
    }

    private static Forma GenerateForma(Random rd) {
        int opt = (int) ((Math.random() * 3) + 1);
        Forma forma = null;
        switch (opt) {
        case 1:
            float comp = rd.nextFloat();
            float altura = rd.nextFloat();
            forma = new Retangulo(comp, altura);
            JOptionPane.showMessageDialog(null,
                    String.format("Retangulo com comprimento %.2f e altura %.2f gerado", comp, altura));
            break;
        case 2:
            float lado = rd.nextFloat();
            forma = new Quadrado(lado);
            JOptionPane.showMessageDialog(null, String.format("Quadrado com lado %.2f gerado", lado));

            break;
        case 3:
            float raio = rd.nextFloat();
            forma = new Circulo(raio);
            JOptionPane.showMessageDialog(null, String.format("Circulo com raio %.2f gerado", raio));
            break;
        }
        return forma;
    }
}
