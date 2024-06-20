package model;

public class Cliente{
    //Atributos
    protected int id;
    protected String nome;
    protected String telefone;
    protected String email;
    private String endereco;
    
    
    //Método Construtor
    public Cliente(int id, String nome, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;        
        this.endereco = endereco;
    }
    
    public Cliente() {
    }
    
    
    //Método Getter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    
    //Método Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    @Override
    public String toString(){
        return getNome();
    }

    
    
}
