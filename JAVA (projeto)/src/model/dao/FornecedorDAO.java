/**/
package model.dao;

import java.sql.*;
import java.util.*;
import model.Connection_BD;
import model.bean.pessoa.Endereco;
import model.bean.pessoa.Fornecedor;
import view._util.Tools_SQL;

public class FornecedorDAO {

    //==========================================================================
    // cria (cadastra) um novo registro
    public static int create(Fornecedor fornecedor) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int returnId = -1;

        try {

            //------------------------------------------------------------------
            // INSERT - Tabela fornecedores
            sql = "INSERT INTO fornecedores(nome, cnpj, telefone, email, rua, numero, cidade, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getEndereco().getRua());
            stmt.setString(6, fornecedor.getEndereco().getNumero());
            stmt.setString(7, fornecedor.getEndereco().getCidade());
            stmt.setString(8, fornecedor.getEndereco().getEstado());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys(); // recupera a key gerada no insert

            // pega o "ID" do cadastro atual
            if (rs.next()) {
                returnId = rs.getInt("id_fornecedor");
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
    public static boolean delete(Fornecedor fornecedor) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // DELETE - Tabela fornecedores
            sql = "DELETE FROM fornecedores WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());
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
    public static boolean update(Fornecedor fornecedor) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // UPDATE - Tabela fornecedores
            sql = "UPDATE fornecedores SET "
                    + "nome = ?, cnpj = ?, telefone = ?, email = ?, "
                    + "rua = ?, numero = ?, cidade = ?, estado = ? "
                    + "WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getEndereco().getRua());
            stmt.setString(6, fornecedor.getEndereco().getNumero());
            stmt.setString(7, fornecedor.getEndereco().getCidade());
            stmt.setString(8, fornecedor.getEndereco().getEstado());
            stmt.setInt(9, fornecedor.getId());

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
    public static List<Fornecedor> read() {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        try {

            String sql = "SELECT * FROM fornecedores";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                Endereco endereco = new Endereco();

                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));

                fornecedor.setId(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(endereco);

                fornecedores.add(fornecedor); // adiciona as colunas à lista

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs);
        }

        return fornecedores; // retorna a lista
    }

} // fim class
