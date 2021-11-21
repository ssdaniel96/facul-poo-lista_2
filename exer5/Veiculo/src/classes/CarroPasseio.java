package classes;

import javax.swing.JOptionPane;

public class CarroPasseio extends Veiculo {
    private String cor;
    private String modelo;

    public CarroPasseio() {
        super();
        setCor("0");
        setModelo("0");
    }

    public CarroPasseio(String cor, String modelo, int peso, int velocMax, float preco, int numCilindro, int potencia) {
        super(peso, velocMax, preco, numCilindro, potencia);
        setCor(cor);
        setModelo(modelo);
    }

    @Override
    public void Get(){
        setModelo(JOptionPane.showInputDialog(null, "Digite o modelo"));
        setCor(JOptionPane.showInputDialog(null, "Digite a cor"));
        super.Get();
    }

    @Override
    public void Print(){
        String msg = "Cor: " + cor + "\n" +
                     "Modelo: " + modelo + "\n" +
                     super.getPrint();

        JOptionPane.showMessageDialog(null, msg);
    }

    public String getCor() {
        return cor;
    }
    private void setCor(String cor) {
        this.cor = cor;
    }
    public String getModelo() {
        return modelo;
    }
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}
