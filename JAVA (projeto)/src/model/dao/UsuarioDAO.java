/**/
package model.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.Connection_BD;
import model.bean.Usuario;
import view._util.Tools_SQL;

public class UsuarioDAO {

    private static Usuario userReturn = null;

    //==========================================================================
    // cria (cadastra) um novo registro
    public static int create(Usuario user) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int returnId = -1;

        try {

            //------------------------------------------------------------------
            // Primeiro INSERT - Tabela acessos (tabela de login e senha)
            sql = "INSERT INTO acessos(login, senha) VALUES (?, ?)";
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys(); // recupera a key gerada no insert

            // pega o "ID" do cadastro atual
            if (rs.next()) {
                returnId = rs.getInt("id_acesso");
            }

            // para confirmar o ID
            // JOptionPane.showMessageDialog(null, "Insert 1 = " + Integer.toString(returnId));
            //
            //------------------------------------------------------------------
            // Segundo INSERT - Tabela usuario
            sql = "INSERT INTO usuarios(id_usuario, nome, nivel_acesso) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, returnId);
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getNivelAcesso());

            stmt.executeUpdate();

            return returnId; // retorna o id para a aplicação

        } catch (SQLException ex) {
            Tools_SQL.mensagemErro(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs); // encerra conexão
        }

        return 0;
    }

    //==========================================================================
    // exclui um registro
    public static boolean delete(Usuario user) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // Primeiro DELETE - Tabela usuario
            sql = "DELETE FROM usuarios WHERE id_usuario = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();

            //------------------------------------------------------------------
            // Segundo DELETE - Tabela acesso (tabela de login e senha)
            sql = "DELETE FROM acessos WHERE id_acesso = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Tools_SQL.mensagemErro(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt); // encerra conexão
        }

        return false;

    }

    //==========================================================================
    // atualiza o registro atual
    public static boolean update(Usuario user) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // Primeiro UPDATE - Tabela acesso (tabela de login e senha)
            sql = "UPDATE acessos SET login = ?, senha = ? WHERE id_acesso = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            stmt.setInt(3, user.getId());

            stmt.executeUpdate();

            //------------------------------------------------------------------
            // Segundo UPDATE - Tabela usuario
            sql = "UPDATE usuarios SET nome = ?, nivel_acesso = ? WHERE id_usuario = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getNivelAcesso());
            stmt.setInt(3, user.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Tools_SQL.mensagemErro(ex);
            //Tools_SQL.testeRetornoException(ex);

        } finally {
            Connection_BD.closeConnection(con, stmt);
        }

        return false;
    }

    //==========================================================================
    // lê e retorna uma lista com todos registros
    public static List<Usuario> read() {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> users = new ArrayList<>();

        try {

            String sql = "SELECT * FROM usuarios, acessos WHERE id_usuario = id_acesso";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_acesso"));
                user.setNome(rs.getString("nome"));
                user.setNivelAcesso(rs.getString("nivel_acesso"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));

                users.add(user); // adiciona as colunas à lista

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs);
        }

        return users; // retorna a lista
    }

    //==========================================================================
    // checa se login existe no banco, se existir retorna o próprio Usuario
    public static Usuario checkLoginReturnUser(String login, String senha) {
        if (checkLogin(login, senha)) {
            return userReturn;
        }
        return null;
    }

    //==========================================================================
    // checa se login existe no banco, se existir retorna true
    public static boolean checkLogin(String login, String senha) {

        Connection con = Connection_BD.getConnection(); // abre conexão
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM usuarios INNER JOIN acessos "
                    + "ON id_usuario = id_acesso "
                    + "WHERE login = ? AND senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            // se ResultSet encontrou
            if (rs.next()) {

                Usuario user = new Usuario();
                user.setId(rs.getInt("id_acesso"));
                user.setNome(rs.getString("nome"));
                user.setNivelAcesso(rs.getString("nivel_acesso"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));

                userReturn = user;

                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs); // fecha conexão
        }

        return false;
    }

} // fim class
