package controller;

import conexao.Conexao;
import controller.Helper.LoginHelper;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import model.modelDAO.UsuarioDAO;
import view.Login;
import view.MenuPrincipal;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema() throws SQLException{
        //Pegar o Usuario da View
        String nome = view.getTxtNome().getText();
        String senha = view.getTxtSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(nome, senha);
        
        //Verificar se o usuário existe no Banco de dados
        Connection con = new Conexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        boolean existe = usuarioDAO.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        //Se o Usuario da view tiver o mesmo usuario e senha do Usuario vindo do banco, redireciona para o menu principal
        if (existe){
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
            this.view.dispose();
        //Senão mostrar mensagem para o Usuario
        } else {
            JOptionPane.showMessageDialog(view, "Usuário ou Senha Inválidos");
        }
        
    }
    
}
