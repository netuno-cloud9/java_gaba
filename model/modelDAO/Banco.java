
package model.modelDAO;

import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.Usuario;
import model.Servico;
import java.text.ParseException;

public class Banco {
    
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;
    
    public static void inicia() throws ParseException{
        
        //Instância dos Objetos
        usuario = new ArrayList<>();
        cliente = new ArrayList<>();
        servico = new ArrayList<>();
        agendamento = new ArrayList<>();
        
        //criando elementos
        
        Usuario usuario1 = new Usuario(1, "Kadu", "123456", "999999999", "kadu@gmail.com");
        Usuario usuario2 = new Usuario(2, "Anna", "123456", "999999999", "anna@gmail.com");
        Usuario usuario3 = new Usuario(3, "Mila", "123456", "999999999", "mila@gmail.com");
        
        Cliente cliente1 = new Cliente(4, "Victor", "Av Sossego", "999999999", "victor@gmail.com");
        Cliente cliente2 = new Cliente(5, "Cintia", "Rua Alto da Serra", "999999999", "cintia@gmail.com");
        
        Servico servico1 = new Servico(1, "Projeto Estrutural", 1500);
        Servico servico2 = new Servico(2, "Projeto Arquitetonico", 4000);
        Servico servico3 = new Servico(3, "Projeto Hidrossanitario", 1300);
        Servico servico4 = new Servico(4, "Projeto Elétrico", 1300);
        Servico servico5 = new Servico(5, "Execução", 20000);
        
        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);
        usuario.add(usuario3);
        
        cliente.add(cliente1);
        cliente.add(cliente2);
        
        servico.add(servico1);
        servico.add(servico2);
        servico.add(servico3);
        servico.add(servico4);
        servico.add(servico5);
        
    }
            
                        
            
}
