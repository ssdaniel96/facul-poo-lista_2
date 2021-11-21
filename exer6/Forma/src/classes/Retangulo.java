package classes;

public class Retangulo extends Forma {

    private float altura;
    private float comprimento;

    public Retangulo(float altura, float comprimento) {
        this.altura = altura;
        this.comprimento = comprimento;
    }

    @Override
    public float calcularArea() {
        return altura * comprimento;
    }

    @Override
    public float calcularPerimetro() {
        return (altura + comprimento) * 2;
    }
    
}
