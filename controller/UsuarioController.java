package controller;

import static java.lang.System.exit;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import model.modelDAO.UsuarioDAO;
import view.NovoUsuario;

public class UsuarioController {

    private final NovoUsuario view;
    private Usuario usuario; // User object to hold current user's data

    public UsuarioController(NovoUsuario view) {
        this.view = view;
        this.usuario = null; // Initialize user as null initially
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public List<Usuario> listarUsuarios() {
    try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = usuarioDAO.selectAll();
        return listaUsuarios;
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, "Erro ao listar usuários", ex);
        JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + ex.getMessage());
        return null;
    }
}
    // No seu UsuarioController.java
public void exibirListaUsuarios() {
    List<Usuario> listaUsuarios = listarUsuarios();
    if (listaUsuarios != null) {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : listaUsuarios) {
            sb.append("Nome: ").append(usuario.getNome())
              .append(", Senha: ").append(usuario.getSenha())
              .append(", Telefone: ").append(usuario.getTelefone())
              .append(", Email: ").append(usuario.getEmail())
              .append("\n");
        }
        JOptionPane.showMessageDialog(view, sb.toString(), "Lista de Usuários", JOptionPane.INFORMATION_MESSAGE);
    }
}
    public void salvaUsuario() {
        String nome = view.getTxtNome().getText();
        String senha = view.getTxtSenha().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();

        if (nome.isEmpty() || senha.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }

        Usuario novoUsuario = new Usuario(nome, senha, telefone, email);

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.insertOrUpdate(novoUsuario); // Use insertOrUpdate method in DAO
            JOptionPane.showMessageDialog(null, "Usuário cadastrado/atualizado com sucesso");
            view.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar/atualizar usuário: " + ex.getMessage());
        }
    }

    public void consultaUsuario() {
        String nome = view.getTxtNome().getText();
        String senha = view.getTxtSenha().getText();

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha nome de usuário e senha.");
            return;
        }

        Usuario usuarioConsulta = new Usuario(nome, senha);

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioConsultado = usuarioDAO.selectPorNomeESenha(usuarioConsulta);

            if (usuarioConsultado != null) {
                JOptionPane.showMessageDialog(null, "Usuário encontrado: " + usuarioConsultado.getNome());
                setUsuario(usuarioConsultado); // Set the current user in the controller
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado ou dados inválidos.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + ex.getMessage());
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editaUsuario() {
        if (usuario != null) { // Check if there's a user selected
            String nome = view.getTxtNome().getText();
            String senha = view.getTxtSenha().getText();
            String telefone = view.getTxtTelefone().getText();
            String email = view.getTxtEmail().getText();

            if (nome.isEmpty() || senha.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                return;
            }

            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setTelefone(telefone);
            usuario.setEmail(email);

            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.update(usuario); // Use update method in DAO
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso");
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado para edição.");
        }
    }

    public void resetarSenha() {
    try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // Ask the user for their email
        String email = JOptionPane.showInputDialog("Por favor informe o email:");
        
        Usuario usuario = usuarioDAO.selectPorEmail(email);
        if (usuario != null) {
            String novaSenha = gerarNovaSenha();
            usuario.setSenha(novaSenha);
            usuarioDAO.update(usuario);
            JOptionPane.showMessageDialog(null, "A nova senha foi enviada para o email: " + usuario.getEmail());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado com esse email.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, "Error resetting the password", ex);
        JOptionPane.showMessageDialog(null, "Error resetting the password: " + ex.getMessage());
    }
}

    public String gerarNovaSenha() {
        // Lógica para gerar uma nova senha de forma aleatória
        return "novaSenha123";
    }
    
    public void deletaUsuario() {
        if (usuario != null && usuario.getId() > 0) {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.delete(usuario);
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso");
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, "Erro ao deletar usuário", ex);
                JOptionPane.showMessageDialog(null, "Erro ao deletar usuário: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado para exclusão ou usuário inválido.");
        }
    }

    public void ListaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
