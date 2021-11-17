import javax.swing.JOptionPane;

import classes.ControleRemoto;
import classes.Televisao;

public class App {
    public static void main(String[] args) throws Exception {
        ControleRemoto controleRemoto = new ControleRemoto(new Televisao());

        boolean continuar = true;
        do {
            int option = EscolherMenu();
            continuar = ExecutarAcao(option, controleRemoto);
        }
        while(continuar);
    }

    private static boolean ExecutarAcao(int option, ControleRemoto controle){
        switch(option){
            case 1:
                controle.AumentarCanal();
                break;
            case 2:
                controle.DiminuirCanal();
                break;
            case 3:
                controle.EscolherCanal();
                break;
            case 4:
                controle.AumentarVolume();
                break;
            case 5:
                controle.DiminuirVolume();
                break;
            case 6:
                controle.informarVolume();
                break;
            case 7:
                controle.informarCanal();
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

    private static String GetStringMenu(){
        return "Selecione uma opção:\n" +
            "1 - Aumentar Canal" + "\n" +
            "2 - Diminuir Canal" + "\n" +
            "3 - Escolher Canal" + "\n" +
            "4 - Aumentar Volume" + "\n" +
            "5 - Diminuir Volume" + "\n" +
            "6 - Ver volume" + "\n" +
            "7 - Ver Canal" + "\n" +
            "0 - Desligar" + "\n";
    }

    private static int EscolherMenu(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(GetStringMenu()));

        if (option < 0 || option > 7){
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            option = EscolherMenu();
        }

        return option;
    }
    

}
