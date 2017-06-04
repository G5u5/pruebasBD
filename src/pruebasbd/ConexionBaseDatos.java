/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class ConexionBaseDatos {
    Connection conn;
    Statement stmt;
    
    static ConexionBaseDatos instancia = null;
    
    private ConexionBaseDatos() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.12:3306/BasePrueba","root","mysql");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public Statement getStatement() {
        return stmt;
    }
    
    public static ConexionBaseDatos instancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
        }
        return instancia;
    }
    
    public static void desconectar() {
        if (instancia != null) {
            try {
                instancia.stmt.execute("shutdown");
                instancia.stmt.close();
                instancia.conn.close();
                instancia = null;
            }
            catch(SQLException e) {
            }
        }
    }
}
