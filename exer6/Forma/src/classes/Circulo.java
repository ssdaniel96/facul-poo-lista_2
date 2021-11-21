package classes;

public class Circulo extends Forma{
    private float raio;

    public Circulo(float raio) {
        this.raio = raio;
    }

    @Override
    public float calcularArea() {
        return (float)Math.pow(Math.PI, 2) * raio;
    }

    @Override
    public float calcularPerimetro() {
        return 2 * (float)Math.PI * raio;
    }  
    
    

}
