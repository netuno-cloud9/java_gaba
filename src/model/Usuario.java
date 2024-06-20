package model;
import java.util.HashMap;
import java.util.Map;

public class Usuario{
    
    //Atributos
    protected int id;
    protected String senha;
    protected String nome;
    protected String telefone;
    protected String email;

    
    //Métodos Construtores
    public Usuario(int id, String nome, String senha, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }    
    
    
    public Usuario(String nome, String senha, String telefone, String email) {
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }


    public Usuario() {
    }

    public Usuario(int i, String example_user, String password123, String example_User, String string, String exampleexamplecom, String admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    //Método Getter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    

    //Método Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
           
            
}