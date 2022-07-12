/*
bd_facsis_trabalho_java
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection_BD {

    // variáveis do banco de dados
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/bd_facsis_trabalho_java";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    //==========================================================================
    //==========================================================================
    // obtêm/abre a conexão
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
        
    } // fim getConnection

    //==========================================================================
    //==========================================================================
    // fecha a conexão, método sobrecarga 01
    public static void closeConnection(Connection con) {
        
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } // fim closeConnection 1

    //--------------------------------------------------------------------------
    // fecha a conexão, método sobrecarga 02
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection(con); // chama closeConnection 1

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } // fim closeConnection 2

    //--------------------------------------------------------------------------
    // fecha a conexão, método sobrecarga 03
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection(con, stmt); // chama closeConnection 2

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } // fim closeConnection 3

    //==========================================================================
    //==========================================================================
} // fim class
