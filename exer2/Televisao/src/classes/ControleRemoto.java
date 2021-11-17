package classes;

import javax.swing.JOptionPane;

public class ControleRemoto {
    private Televisao tv;

    public ControleRemoto(Televisao tv){
        this.tv = tv;
    }

    public void AumentarVolume(){
        tv.aumentarVolume();
        informarVolume();
    }

    public void DiminuirVolume(){
        tv.diminuirVolume();
        informarVolume();
    }

    public void AumentarCanal(){
        tv.AumentarCanal();
        informarCanal();
    }

    public void DiminuirCanal(){
        tv.DiminuirCanal();
        informarCanal();
    }

    public void EscolherCanal()
    {
        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o canal desejado"));
        tv.setCanal(valor);
        informarCanal();
    }

    public void informarVolume(){
        JOptionPane.showMessageDialog(null, String.format("Volume: %d/100", tv.getVolume()));
    }

    public void informarCanal(){
        JOptionPane.showMessageDialog(null, String.format("Canal %d", tv.getCanal()));
    }
}