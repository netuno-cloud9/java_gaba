package controller;

import view.Agenda;
import view.MenuPrincipal;
import view.NovoUsuario;

public class MenuPrincipalController {
    
    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    
    public void navegarParaAgenda(){
        
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
        
    }
    
    public void navegarParaAtualizar(){
        
        NovoUsuario novoUsuario = new NovoUsuario();
        novoUsuario.setVisible(true);
        
    }
    
    
    
    
}
