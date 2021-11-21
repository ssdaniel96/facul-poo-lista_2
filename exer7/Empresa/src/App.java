import javax.swing.JOptionPane;

import classes.Empresa;
import classes.Restaurante;

public class App {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Instanciando empresa sem parametros...");
        Empresa empresa = new Empresa();
        empresa.Print();
        JOptionPane.showMessageDialog(null, "Chamando get...");
        empresa.Get();
        empresa.Print();
        JOptionPane.showMessageDialog(null, "Instanciando empresa com parametros...");
        empresa = new Empresa("UNASP", "R. Walter Boger s/n", "Engenheiro Coelho", "SP", "13165000", "19 38586500");
        empresa.Print();
        
        JOptionPane.showMessageDialog(null, "Instanciando restaurante sem parametros...");
        Restaurante restaurante = new Restaurante();
        restaurante.Print();
        JOptionPane.showMessageDialog(null, "Chamando get...");
        restaurante.Get();
        restaurante.Print();
        JOptionPane.showMessageDialog(null, "Instanciando restaurante com parametros...");
        restaurante = new Restaurante("Ovolactovegetariano", 20f, "Restaurante UNASP", "R. Walter Boger s/n", "Engenheiro Coelho", "SP", "13165000", "19 38586500");
        restaurante.Print();
    }
}
