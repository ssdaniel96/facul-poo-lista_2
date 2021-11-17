package agenda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import pessoas.Pessoa;

public class Agenda {
    private static final int agenda_limite = 10;
    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    private boolean IsAgendaCheia(){
        return pessoas.size() >= agenda_limite;
    }

    private boolean IsAgendaVazia(){
        return pessoas.size() == 0;
    }

    public void ImprimirPessoas(){
        if (IsAgendaVazia()){
            JOptionPane.showMessageDialog(null, "Agenda está vazia");
            return;
        }

        String dadosPessoa = "";
        for (int i=0; i < pessoas.size(); i++) {
            dadosPessoa += String.format("Num: %d\n%s\n\n", i+1, pessoas.get(i).toString());
        }

        JOptionPane.showMessageDialog(null, dadosPessoa);
    }

    public void ImprimePessoa(int index){
        Pessoa pessoa = Busca(index);
        JOptionPane.showMessageDialog(null, pessoa.toString());
    }

    public Pessoa Busca(int index){
        if (index > pessoas.size()-1){
            JOptionPane.showMessageDialog(null, String.format("A agenda não possui o index %d", index));
        }

        return pessoas.get(index);
    }

    public Pessoa Buscar(String nome){
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getName().equals(nome)){
                JOptionPane.showMessageDialog(null, 
                    String.format("%s encontrado na posição %d da agenda\nEssa busca sempre retornará apenas o primeiro resultado", nome, pessoas.indexOf(pessoa) + 1));
                return pessoa;
            }
        }

        JOptionPane.showMessageDialog(null, String.format("A busca por %s não obteve resultados", nome));
        return null;
    }

    public void Remover(String name){
        JOptionPane.showMessageDialog(null, "Aviso, essa busca removerá o primeiro registro com o nome solicitado");
        if (IsAgendaVazia()){
            JOptionPane.showMessageDialog(null, "Agenda está vazia, insira alguém antes de remover");
            return;
        }

        Pessoa pessoa = Buscar(name);
        pessoas.remove(pessoa);
        JOptionPane.showMessageDialog(null, String.format("%s foi removido com sucesso", name));
    }

    public void Armazenar(String name, int idade, float altura){
        if (IsAgendaCheia()){
            JOptionPane.showMessageDialog(null, "Lista lotada! Remova alguém antes de inserir um novo!");
            return;
        }

        Pessoa pessoa = new Pessoa(name, idade, altura);
        pessoas.add(pessoa);
        JOptionPane.showMessageDialog(null, String.format("%s foi adicionado com sucesso", name));
    }
}
