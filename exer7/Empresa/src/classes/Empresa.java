package classes;

import javax.swing.JOptionPane;

public class Empresa{
    public String Nome;
    public String Endereco;
    public String Cidade;
    public String Estado;
    public String CEP;
    public String Fone;

    public Empresa() {
        super();
    }

    public Empresa(String nome, String endereco, String cidade, String estado, String cEP, String fone) {
        Nome = nome;
        Endereco = endereco;
        Cidade = cidade;
        Estado = estado;
        CEP = cEP;
        Fone = fone;
    }

    public void Get(){
        Nome = JOptionPane.showInputDialog(null, "Digite o nome");
        Endereco = JOptionPane.showInputDialog(null, "Digite o endereço");
        Cidade = JOptionPane.showInputDialog(null, "Digite a cidade");
        Estado = JOptionPane.showInputDialog(null, "Digite o estado");
        CEP = JOptionPane.showInputDialog(null, "Digite o CEP");
        Fone = JOptionPane.showInputDialog(null, "Digite o telefone");
    }

    @Override
    public String toString(){
        return "Nome: " + Nome + "\n" + 
               "Endereço: " + Endereco + "\n" + 
               "Cidade: " + Cidade + "\n" + 
               "Estado: " + Estado + "\n" + 
               "CEP: " + CEP + "\n" + 
               "Fone: " + Fone + "\n";
    }

    public void Print(){
        JOptionPane.showMessageDialog(null, toString());
    }
}