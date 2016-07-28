
package Dato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eddy Escalante
 */
public class Conexion {
     private static String Servidor = "jdbc:mysql://localhost:3306/sistemainventario";
    private static String user="root";
    private static String pass="";
    private static String driver="com.mysql.jdbc.Driver";
    private  Connection con; 
    
    public Conexion() {
        try
        {
            Class.forName(driver);
            con=(Connection) DriverManager.getConnection(Servidor, user, pass);
            System.out.println("conexion realizada con exito");

        }catch(Exception ee){
            System.out.println("conexion fallida");
        }   
    }
    public Connection getConexion(){
        
        return con;
    }
    
    public Connection cerrarConexion(){
        try {
            con.close();
             System.out.println("Cerrando conexion a ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con=null;
        return con;
    }
}
