package model;

public class Servico{
    
    private int id;
    private String servico;
    private float valor;

    //Método Construtor
    public Servico(int id, String servico, float valor) {
        this.id = id;
        this.servico = servico;
        this.valor = valor;
    }

    //Métodos Getters
    public int getId() {
        return id;
    }

    public String getServico() {
        return servico;
    }

    public float getValor() {
        return valor;
    }
    
    
    //Métodos Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }    
    
    
    @Override
    public String toString(){
        return getServico();
    }    
    
}
