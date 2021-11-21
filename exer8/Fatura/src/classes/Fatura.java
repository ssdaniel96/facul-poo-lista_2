package classes;

import javax.swing.JOptionPane;

public class Fatura {
    private int Numero;
    private String Descricao;
    private int Quantidade;
    private double Preco;

    public double getTotalFatura() {
        double total = Quantidade * Preco;
        return total > 0 ? total : 0;
    }

    public void Print() {
        String message = "Numero: " + Numero + "\n" + "Descrição: " + Descricao + "\n" + "Quantidade: " + Quantidade
                + "\n" + String.format("Preço por item: %.2f\n", Preco)
                + String.format("Preço total: %.2f\n", getTotalFatura());
        JOptionPane.showMessageDialog(null, message);
    }

    public Fatura(int numero, String descricao, int quantidade, double preco) {
        setNumero(numero);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco > 0 ? preco : 0;
    }

}
