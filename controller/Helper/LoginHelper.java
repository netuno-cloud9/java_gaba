package controller.Helper;

import model.Usuario;
import view.Login;

public class LoginHelper implements IHelper{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        //Pegar o Usuario da View
        String nome = view.getTxtNome().getText();
        String senha = view.getTxtSenha().getText();        
        
        Usuario modelo = new Usuario(nome,senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTxtNome().setText(nome);
        view.getTxtSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getTxtNome().setText("");
        view.getTxtSenha().setText("");  
    }
    
}
