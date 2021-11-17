import javax.swing.JOptionPane;

import agenda.Agenda;

public class App {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Bem vindo a sua agenda");
        Agenda agenda = new Agenda();
        // descomente para testes
        // agenda.Armazenar("Daniel", 24, 1.75f);
        // agenda.Armazenar("José", 24, 1.75f);

        boolean continuar = true;
        do {
            int option = EscolherMenu();
            continuar = ExecutarAcao(option, agenda);
        }
        while(continuar);

        JOptionPane.showMessageDialog(null, "Obrigado por usar a nossa agenda!");
    }

    private static int EscolherMenu(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(GetStringMenu()));

        if (option < 0 || option > 5){
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            option = EscolherMenu();
        }

        return option;
    }

    private static String GetStringMenu(){
        return "Selecione uma opção:\n" +
            "1 - Armazenar nova pessoa" + "\n" +
            "2 - Remover pessoa" + "\n" +
            "3 - Buscar pessoa" + "\n" +
            "4 - Imprimir agenda" + "\n" +
            "5 - Imprimir pessoa" + "\n" +
            "0 - Sair" + "\n";
    }

    private static int getValidIndex(){
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a posição para busca"));
        if (index < 1 || index > 10){
            JOptionPane.showMessageDialog(null, "Posição deve ser entre 0 a 10!");
            index = getValidIndex();
        }
        return index;
    }

    private static boolean ExecutarAcao(int option, Agenda agenda){
        switch(option){
            case 1:
                String nome = JOptionPane.showInputDialog(null, "Digite o nome");
                int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade"));
                float altura = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a altura (m)"));
                agenda.Armazenar(nome, idade, altura);
                break;
            case 2:
                nome = JOptionPane.showInputDialog(null, "Digite o nome para remover (removeremos a primeira aparição");
                agenda.Remover(nome);
                break;
            case 3:
                nome = JOptionPane.showInputDialog(null, "Digite o nome para busca (retornaremos a primeira aparição");
                agenda.Buscar(nome);
                break;
            case 4:
                agenda.ImprimirPessoas();
                break;
            case 5:
                int index = getValidIndex();
                agenda.ImprimePessoa(index-1);
                break;
            case 0:
                return false;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                option = EscolherMenu();
                break;
        }
        return true;
    }
}
