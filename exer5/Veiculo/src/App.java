import javax.swing.JOptionPane;

import classes.Caminhao;
import classes.CarroPasseio;
import classes.Motor;
import classes.Veiculo;

public class App {
    public static void main(String[] args){

        JOptionPane.showMessageDialog(null, "Instanciando motor sem parametros...");
        Motor motor = new Motor();
        motor.Print();
        JOptionPane.showMessageDialog(null, "Chamando metodo get...");
        motor.Get();
        motor.Print();
        JOptionPane.showMessageDialog(null, "Instanciando motor parametrizado...");
        motor = new Motor(10, 20);
        motor.Print();

        JOptionPane.showMessageDialog(null, "Instanciando veiculo sem parametros...");
        Veiculo veiculo = new Veiculo();
        veiculo.Print();
        JOptionPane.showMessageDialog(null, "Chamando metodo get...");
        veiculo.Get();
        veiculo.Print();
        JOptionPane.showMessageDialog(null, "Instanciando veiculo parametrizado...");
        veiculo = new Veiculo(200, 200, 20000f, 4, 100);
        veiculo.Print();

        JOptionPane.showMessageDialog(null, "Instanciando carro passeio sem parametros...");
        CarroPasseio carro = new CarroPasseio();
        carro.Print();
        JOptionPane.showMessageDialog(null, "Chamando metodo get...");
        carro.Get();
        carro.Print();
        JOptionPane.showMessageDialog(null, "Instanciando carro passeio parametrizado...");
        carro = new CarroPasseio("Amarelo", "Honda fit G3", 200, 200, 20000f, 4, 100);
        carro.Print();

        JOptionPane.showMessageDialog(null, "Instanciando caminhão sem parametros...");
        Caminhao caminhao = new Caminhao();
        caminhao.Print();
        JOptionPane.showMessageDialog(null, "Chamando metodo get...");
        caminhao.Get();
        caminhao.Print();
        JOptionPane.showMessageDialog(null, "Instanciando caminhao parametrizado...");
        caminhao = new Caminhao(2, 5, 20, 200, 200, 20000f, 4, 100);
        caminhao.Print();

    }
}
