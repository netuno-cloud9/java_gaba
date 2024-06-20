package model.modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    private final Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public UsuarioDAO() {
        con = new Conexao().getConnection();
    }

    // C (create)
    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, senha, telefone, email) VALUES (?, ?, ?, ?)";
        pst = con.prepareStatement(sql);
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getSenha());
        pst.setString(3, usuario.getTelefone());
        pst.setString(4, usuario.getEmail());
        pst.execute();
    }

    // R (read)
    public ArrayList<Usuario> selectAll() throws SQLException {
        String sql = "SELECT * FROM usuario";
        pst = con.prepareStatement(sql);
        return pesquisa(pst);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement pst) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (ResultSet resultSet = pst.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Usuario usuarioComDadosDoBanco = new Usuario(id, nome, senha, telefone, email);
                usuarios.add(usuarioComDadosDoBanco);
            }
        }
        return usuarios;
    }

    public Usuario selectPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ArrayList<Usuario> usuarios = pesquisa(pst);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // U (update)
    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, senha = ?, telefone = ?, email = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getTelefone());
            pst.setString(4, usuario.getEmail());
            pst.setInt(5, usuario.getId());
            pst.executeUpdate();
        }
    }

    // Insert or Update
    public void insertOrUpdate(Usuario usuario) throws SQLException {
        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    // D (delete)
    public void delete(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, usuario.getId());
        pst.executeUpdate();
    }

    // Authenticate
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getSenha());
        rs = pst.executeQuery();
        return rs.next();
    }

    public Usuario selectPorNomeESenha(Usuario usuario) throws SQLException {
        Usuario usuarioConsultado = null;
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getSenha());
        rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            usuarioConsultado = new Usuario(id, nome, usuario.getSenha(), telefone, email);
        }
        return usuarioConsultado;
    }

    public Usuario selectPorEmail(String email) throws SQLException {
        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNome(resultSet.getString("nome"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setSenha(resultSet.getString("senha"));
                    usuario.setTelefone(resultSet.getString("telefone"));
                }
            }
        }

        return usuario;
    }
}