package pessoas;

public class Pessoa {
    private String name;
    private int idade;
    private float altura;

    public Pessoa(String name, int idade, float altura) {
        setName(name);
        setIdade(idade);
        setAltura(altura);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s\nIdade: %d\nAltura: %.2f m", getName(), getIdade(), getAltura());
    }
    
}
