package classes;

import javax.swing.JOptionPane;

public class Motor{
    private int NumCilindro;
    private int Potenci;
    
    public Motor() {
        setNumCilindro(0);
        setPotenci(0);
    }

    public Motor(int numCilindro, int potenci) {
        setNumCilindro(numCilindro);
        setPotenci(potenci);
    }

    public void Get() {
        setNumCilindro(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o num do Cilindro")));
        setPotenci(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a potencia")));
    }

    protected String getPrint() {
        return "Num Cilindro: " + NumCilindro + "\nPotencia: " + Potenci + "\n";
    }

    public void Print(){
        JOptionPane.showMessageDialog(null, getPrint());
    }
    
    public int getPotenci() {
        return Potenci;
    }

    public void setPotenci(int potenci) {
        this.Potenci = potenci;
    }

    
    public int getNumCilindro() {
        return NumCilindro;
    }

    public void setNumCilindro(int numCilindro) {
        this.NumCilindro = numCilindro;
    }

    
}