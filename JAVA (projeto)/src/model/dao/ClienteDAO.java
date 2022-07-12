/**/
package model.dao;

import java.sql.*;
import java.util.*;
import model.Connection_BD;
import model.bean.pessoa.Cliente;
import model.bean.pessoa.Endereco;
import view._util.Tools_SQL;

public class ClienteDAO {

    //==========================================================================
    // cria (cadastra) um novo registro
    public static int create(Cliente cliente) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int returnId = -1;

        try {

            //------------------------------------------------------------------
            // INSERT - Tabela clientes
            sql = "INSERT INTO clientes(nome, cpf, telefone, email, rua, numero, cidade, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco().getRua());
            stmt.setString(6, cliente.getEndereco().getNumero());
            stmt.setString(7, cliente.getEndereco().getCidade());
            stmt.setString(8, cliente.getEndereco().getEstado());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys(); // recupera a key gerada no insert

            // pega o "ID" do cadastro atual
            if (rs.next()) {
                returnId = rs.getInt("id_cliente");
            }

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
    public static boolean delete(Cliente cliente) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // DELETE - Tabela clientes
            sql = "DELETE FROM clientes WHERE id_cliente = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
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
    public static boolean update(Cliente cliente) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // UPDATE - Tabela clientes
            sql = "UPDATE clientes SET "
                    + "nome = ?, cpf = ?, telefone = ?, email = ?, "
                    + "rua = ?, numero = ?, cidade = ?, estado = ? "
                    + "WHERE id_cliente = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco().getRua());
            stmt.setString(6, cliente.getEndereco().getNumero());
            stmt.setString(7, cliente.getEndereco().getCidade());
            stmt.setString(8, cliente.getEndereco().getEstado());
            stmt.setInt(9, cliente.getId());

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
    public static List<Cliente> read() {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {

            String sql = "SELECT * FROM clientes";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                Endereco endereco = new Endereco();

                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));

                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(endereco);

                clientes.add(cliente); // adiciona as colunas à lista

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs);
        }

        return clientes; // retorna a lista
    }

} // fim class
