package classes;

import javax.swing.JOptionPane;

public class Caminhao extends Veiculo{
    private int CargaMaxima;
    private int AlturaMax;
    private int Comprimento;

    public Caminhao() {
        super();
        setCargaMaxima(0);
        setAlturaMax(0);
        setComprimento(0);
    }

    public Caminhao(int cargaMaxima, int alturaMax, int comprimento, int peso, int velocMax, float preco, int numCilindro, int potencia) {
        super(peso, velocMax, preco, numCilindro, potencia);
        setCargaMaxima(cargaMaxima);
        setAlturaMax(alturaMax);
        setComprimento(comprimento);
    }

    public void Get(){
        setCargaMaxima(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a carga maxima")));
        setAlturaMax(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a altura maxima")));
        setComprimento(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o comprimento")));
        super.Get();
    }

    public void Print(){
        String msg = "Carga máxima: " + getCargaMaxima() + " toneladas\n" +
                     "Altura máxima: " + getAlturaMax() + "m\n" +
                     "Comprimento: " + getComprimento() + "m\n" + 
                     super.getPrint();
        JOptionPane.showMessageDialog(null, msg);
    }

    public int getCargaMaxima() {
        return CargaMaxima;
    }

    private void setCargaMaxima(int cargaMaxima) {
        CargaMaxima = cargaMaxima;
    }

    public int getAlturaMax() {
        return AlturaMax;
    }

    private void setAlturaMax(int alturaMax) {
        AlturaMax = alturaMax;
    }

    public int getComprimento() {
        return Comprimento;
    }

    private void setComprimento(int comprimento) {
        Comprimento = comprimento;
    }

    
}

