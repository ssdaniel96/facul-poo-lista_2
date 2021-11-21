package classes;
public abstract class RoboAbstrato{
    private int direcao = 180;

    public int getDirecao(){
        return direcao;
    }

    protected void mudaDirecao(int direcao){
        this.direcao = direcao;
    }
}