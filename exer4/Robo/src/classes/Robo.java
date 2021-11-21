package classes;

public class Robo extends RoboAbstrato{
    public void mudaDirecao(int direcao){
        if (direcao < 45 || direcao > 315){
            super.mudaDirecao(0);
        }
        else if (direcao >= 45 && direcao < 135){
            super.mudaDirecao(90);
        }
        else if (direcao >= 135 && direcao < 225){
            super.mudaDirecao(180);
        }
        else {
            super.mudaDirecao(270);
        }
    }
}
