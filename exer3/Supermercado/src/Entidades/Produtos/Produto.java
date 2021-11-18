package Entidades.Produtos;

public class Produto {
    private String nome;
    private float valor;

    public Produto(String nome, float valor) throws Exception {
        setNome(nome);
        setValor(valor);
    }
    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    private void setValor(float valor) throws Exception {
        if (valor < 0.01){
            throw new Exception("Valor não pode ser menor que R$ 0,01");
        }

        this.valor = valor;
    }

    
}