package classes;

public class Motor{
    private int NumCilindro;
    private int Potenci;
    
    public Motor() {
        setNumCilindro(0);
        setPotenci(0);
    }

    public Motor(int numCilindro, int potenci) {
        setNumCilindro(numCilindro);
        setPotenci(potenci);
    }

    public Get() {
        
    }
    
    public int getPotenci() {
        return Potenci;
    }

    public void setPotenci(int potenci) {
        this.Potenci = potenci;
    }

    
    public int getNumCilindro() {
        return NumCilindro;
    }

    public void setNumCilindro(int numCilindro) {
        this.NumCilindro = numCilindro;
    }

    
}