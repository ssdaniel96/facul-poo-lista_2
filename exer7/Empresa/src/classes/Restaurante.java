package classes;

import javax.swing.JOptionPane;

public class Restaurante extends Empresa {
    public String TipoComida;
    public float PrecoMedioPorPrato;

    public Restaurante() {
        super();
    }

    public Restaurante(String tipoComida, float precoMedioPorPrato, String nome, String endereco, String cidade, String estado, String cEP, String fone) {
        super(nome, endereco, cidade, estado, cEP, fone);
        TipoComida = tipoComida;
        PrecoMedioPorPrato = precoMedioPorPrato;
    }

    public void Get(){
        super.Get();
        TipoComida = JOptionPane.showInputDialog(null, "Digite o tipo de comida");
        PrecoMedioPorPrato = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preço médio por prato"));
    }

    public void Print(){
        String message = super.toString() + 
                         "Tipo de comida: " + TipoComida + "\n" +
                         String.format("Preço médio por prato %.2f\n", PrecoMedioPorPrato);

        JOptionPane.showMessageDialog(null, message);
    }
}
