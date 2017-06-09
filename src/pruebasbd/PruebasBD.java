/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasbd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Jesús Durántez Prieto
 */
public class PruebasBD {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha = new Date();
        ResultSet rs;
        Scanner teclado = new Scanner(System.in);
        
        /*
        System.out.print("DENEI: ");
        int dni = teclado.nextInt();
        
        System.out.print("Letra: ");
        String letra = teclado.next();
        */
        System.out.print("Nombre: ");
        String nombre = teclado.next();
        
        
        try {
            rs = ConexionBaseDatos.instancia().getStatement().executeQuery(
                "select * from prueba where dni=71934393"   
                );
            if (rs.next()){
                System.out.println("D.N.I.: " + rs.getString(1) + rs.getString(2) + ".\nNombre: " + rs.getString(3) + ".\nDirección: " + rs.getString(4));
                System.out.println("----------------------------------");
            } else {
                System.err.println("RESULTADO VACIO");
            }
        }catch (Exception e){
            System.err.println("FALLO AL BUSCAR: " + e);
        }
        /*
        System.out.println("Direccion: ");
        String direccion = teclado.next();
                
        try {
            rs = ConexionBaseDatos.instancia().getStatement().executeQuery(
                "select * from prueba;"
                );
            while (rs.next()){
                System.out.println("D.N.I.: " + rs.getString(1) + rs.getString(2) + ".\nNombre: " + rs.getString(3) + ".\nDirección: " + rs.getString(4));
                System.out.println("----------------------------------");
            }
        }catch (Exception e){
            System.err.println("FALLO EN BASE DATOS: " + e);
        }
        System.out.println("");
        System.out.println("");
        try {
            ConexionBaseDatos.instancia().getStatement().execute(
                "insert into prueba values (" + Integer.toString(dni) + ", '" + letra + "', '" + nombre +
                        "', '" + direccion + "');"   
                );
        }catch (Exception e){
            System.err.println("DATO REPETIDO: " + e);
        }
        
        try {
            rs = ConexionBaseDatos.instancia().getStatement().executeQuery(
                "select * from prueba;"   
                );
            while (rs.next()){
                System.out.println("D.N.I.: " + rs.getString(1) + rs.getString(2) + ".\nNombre: " + rs.getString(3) + ".\nDirección: " + rs.getString(4));
                System.out.println("----------------------------------");
            }
        }catch (Exception e){
            System.err.println("FALLO EN BASE DATOS: " + e);
        }
        */
        
        
    /*
    public void crear(Venta v) throws ErrorCreacionVenta {        
        try {
            ConexionBD.instancia().getStatement().execute(
                "insert into ventas values (" +
                Integer.toString(v.getNum()) + ", " +
                "'" + sdf.format(v.getFecha()) + "')"                
                );
                       
            for (Item item: v.getItems()) {
                ConexionBD.instancia().getStatement().execute(
                    "insert into items values (" +
                    Integer.toString(v.getNum()) + ", " +
                    Integer.toString(item.getCantidad()) + ", " +
                    "'" + item.getDescripcion() + "', " +
                    Float.toString(item.getImporteUnidad()) + ")"
                );                
            }
            
        } catch (SQLException e) {
            throw new ErrorCreacionVenta();
        }        
    }
    
    public Venta buscarPorNum(int num) {
        Venta v = null;

        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select fecha from ventas where num=" + Integer.toString(num)                
                );
                 
            if (rs.next()) {
                v = new Venta(num);
                v.setFecha(rs.getDate(1));
                
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select cantidad, descripcion, importeUnidad from items where num_venta=" + 
                        Integer.toString(num)
                    );
            
                while (rsi.next()) {
                    v.anadirItem(new Item(rsi.getInt(1), rsi.getString(2), rsi.getFloat(3)));
                }
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return v;        
    }

    public void actualizar(Venta v) {
        // Implementar
    }
    
    public void borrar(Venta v) throws ErrorBorradoVenta {
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from items where num_venta=" + 
                    Integer.toString(v.getNum())
                    );
            ConexionBD.instancia().getStatement().execute(
                    "delete from ventas where num=" + 
                    Integer.toString(v.getNum())
                    );
        } catch (SQLException e) {
            throw new ErrorBorradoVenta();
        }
    }
    
    public static DAOVenta instancia() {
        if (instancia == null) {
            instancia = new DAOVenta();
        }
        
        return instancia;
    }
    */
       
    }
}

//******************************************************************************
//******************************************************************************
/*
    static PruebasBD instancia = null;
    SimpleDateFormat sdf;
    
    private PruebasBD() {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    } 
    
    public void crear(Venta v) throws ErrorCreacionVenta {        
        try {
            ConexionBD.instancia().getStatement().execute(
                "insert into ventas values (" +
                Integer.toString(v.getNum()) + ", " +
                "'" + sdf.format(v.getFecha()) + "')"                
                );
                       
            for (Item item: v.getItems()) {
                ConexionBD.instancia().getStatement().execute(
                    "insert into items values (" +
                    Integer.toString(v.getNum()) + ", " +
                    Integer.toString(item.getCantidad()) + ", " +
                    "'" + item.getDescripcion() + "', " +
                    Float.toString(item.getImporteUnidad()) + ")"
                );                
            }
            
        } catch (SQLException e) {
            throw new ErrorCreacionVenta();
        }        
    }
    
    public Venta buscarPorNum(int num) {
        Venta v = null;

        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select fecha from ventas where num=" + Integer.toString(num)                
                );
                 
            if (rs.next()) {
                v = new Venta(num);
                v.setFecha(rs.getDate(1));
                
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                    "select cantidad, descripcion, importeUnidad from items where num_venta=" + 
                        Integer.toString(num)
                    );
            
                while (rsi.next()) {
                    v.anadirItem(new Item(rsi.getInt(1), rsi.getString(2), rsi.getFloat(3)));
                }
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return v;        
    }

    public void actualizar(Venta v) {
        // Implementar
    }
    
    public void borrar(Venta v) throws ErrorBorradoVenta {
        try {
            ConexionBD.instancia().getStatement().execute(
                    "delete from items where num_venta=" + 
                    Integer.toString(v.getNum())
                    );
            ConexionBD.instancia().getStatement().execute(
                    "delete from ventas where num=" + 
                    Integer.toString(v.getNum())
                    );
        } catch (SQLException e) {
            throw new ErrorBorradoVenta();
        }
    }
    
    public static DAOVenta instancia() {
        if (instancia == null) {
            instancia = new DAOVenta();
        }
        
        return instancia;
    }
    }
    */