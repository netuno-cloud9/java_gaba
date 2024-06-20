package model;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private String data;
    private String observacao;
    
    //Método Construtor
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }
    
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String observacao){
        this(id,cliente,servico,valor,data);
        this.observacao = observacao;
    }
    
    //Métodos Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public float getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
    
    /*public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }*/

    public String getObservacao() {
        return observacao;
    }
    
    //Métodos Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
