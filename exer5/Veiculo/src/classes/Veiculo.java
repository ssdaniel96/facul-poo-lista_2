package classes;

import javax.swing.JOptionPane;

public class Veiculo extends Motor{
    private int Peso;
    private int VelocMax;
    private float Preco;
    
    // O requisito dizia pra construir um construtor sem argumentos e "inicializar os valores recebidos como argumento", 
    // não faz sentido então vou criar conforme a classe Motor;
    public Veiculo() { 
        super();
        setPreco(0);
        setVelocMax(0);
        setPeso(0);
    }

    public Veiculo(int peso, int velocMax, float preco, int numCilindro, int potencia) {
        super(numCilindro, potencia);
        setPreco(preco);
        setVelocMax(velocMax);
        setPeso(peso);
    }

    @Override
    public void Get(){
        setPeso(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o peso")));
        setVelocMax(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a velocidade maxima")));
        setPreco(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preço")));
        super.Get();
    }

    @Override
    protected String getPrint(){
        return "Peso: " + getPeso() + "KG" + "\n" +
                         "Velocidade máxima: " + getVelocMax() + "Km/h" + "\n" +
                         String.format("Preço: R$ %.2f\n", getPreco()) + 
                         super.getPrint();
    }

    @Override
    public void Print(){
        JOptionPane.showMessageDialog(null, getPrint());
    }



    public float getPreco() {
        return Preco;
    }

    private void setPreco(float preco) {
        this.Preco = preco;
    }

    public int getPeso() {
        return Peso;
    }

    private void setPeso(int peso) {
        this.Peso = peso;
    }

    public int getVelocMax() {
        return VelocMax;
    }

    private void setVelocMax(int velocMax) {
        this.VelocMax = velocMax;
    }
}
