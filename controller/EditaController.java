package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import model.modelDAO.UsuarioDAO;
import view.EditaUsuario;

public class EditaController {

    private final EditaUsuario view; // Reference to the view
    private Usuario usuario; // User object to hold current user's data

    public EditaController(EditaUsuario view) {
        this.view = view;
        this.usuario = null; // Initialize user as null initially
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Method to query user data for editing
    public void consultaUsuario() {
        if (usuario != null) {
            // Populate view fields with user data
            
        } else {
            JOptionPane.showMessageDialog(view, "Nenhum usuário selecionado para consulta.");
        }
    }

    // Method to update user information
    public void editaUsuario() {
        if (usuario != null) {
            

            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.update(usuario); // Use update method in DAO
                JOptionPane.showMessageDialog(view, "Usuário atualizado com sucesso");
                view.dispose(); // Close the view after successful update
            } catch (SQLException ex) {
                Logger.getLogger(EditaController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao atualizar usuário: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view, "Nenhum usuário selecionado para edição.");
        }
    }

    // Method to delete user
    public void deletaUsuario() {
        if (usuario != null && usuario.getId() > 0) {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.delete(usuario); // Use delete method in DAO
                JOptionPane.showMessageDialog(view, "Usuário deletado com sucesso");
                view.dispose(); // Close the view after successful delete
            } catch (SQLException ex) {
                Logger.getLogger(EditaController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao deletar usuário: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view, "Nenhum usuário selecionado para exclusão ou usuário inválido.");
        }
    }
}
