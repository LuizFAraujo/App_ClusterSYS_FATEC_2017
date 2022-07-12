/**/
package model.dao;

import java.sql.*;
import java.util.*;
import model.Connection_BD;
import model.bean.Produto;
import view._util.Tools_SQL;

public class ProdutoDAO {

    //==========================================================================
    // cria (cadastra) um novo registro
    public static int create(Produto produto) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int returnId = -1;

        try {

            //------------------------------------------------------------------
            // INSERT - Tabela clientes
            sql = "INSERT INTO produtos(nome, categoria, preco, fornecedor_id) "
                    + "VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getId_fornecedor());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys(); // recupera a key gerada no insert

            // pega o "ID" do cadastro atual
            if (rs.next()) {
                returnId = rs.getInt("id_produto");
            }

            return returnId; // retorna o id para a aplicação

        } catch (SQLException ex) {
            Tools_SQL.mensagemErro(ex);
//            Tools_SQL.testeRetornoException(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs); // encerra conexão
        }

        return 0;
    }

    //==========================================================================
    // exclui um registro
    public static boolean delete(Produto produto) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;

        try {

            //------------------------------------------------------------------
            // DELETE - Tabela clientes
            sql = "DELETE FROM produtos WHERE id_produto = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Tools_SQL.mensagemErro(ex);
//            Tools_SQL.testeRetornoException(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt); // encerra conexão
        }

        return false;

    }

    //==========================================================================
    // atualiza o registro atual
    public static boolean update(Produto produto) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        String sql = null;
////
        try {

            //------------------------------------------------------------------
            // UPDATE - Tabela clientes
            sql = "UPDATE produtos SET nome = ?, categoria = ?, preco = ?, fornecedor_id = ? "
                    + "WHERE id_produto = ?";

            stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getId_fornecedor());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            Tools_SQL.mensagemErro(ex);
//            Tools_SQL.testeRetornoException(ex);

        } finally {
            Connection_BD.closeConnection(con, stmt);
        }

        return false;
    }

    //==========================================================================
    // lê e retorna uma lista com todos registros
    public static List<Produto> read() {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {

            String sql = "SELECT * FROM produtos";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setId_fornecedor(rs.getInt("fornecedor_id"));

                produtos.add(produto); // adiciona as colunas à lista

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs);
        }

        return produtos; // retorna a lista
    }

    //==========================================================================
    // lê e retorna um produto apartir de um ID
    public static Produto readID(Integer id) {

        Connection con = Connection_BD.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Produto produto = new Produto();

        try {

            String sql = "SELECT * FROM produtos WHERE id_produto = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setId_fornecedor(rs.getInt("fornecedor_id"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection_BD.closeConnection(con, stmt, rs);
        }

        return produto; // retorna o produto
    }

} // fim class
