package classes;

public class Televisao {
    private int canal = 1;
    private int volume = 50;

    public void AumentarCanal(){
        canal++;
    }

    public void DiminuirCanal(){
        if (canal > 1){
            canal--;
        }
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal < 1 ? 1 : canal;
    }

    public void diminuirVolume(){
        if (volume > 1){
            volume --;
        }
    }

    public void aumentarVolume(){
        if (volume < 100){
            volume ++;
        }
    }

    public int getVolume() {
        return volume;
    }    
    
}
