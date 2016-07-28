/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class DNotaPrestamo {
    int idNota_Prestamo;
    int Empleado_IdEmpleado;
    int Usuario_IdUsuario;
    String fecha;
    Conexion con;

    public DNotaPrestamo() {
        this.con =new  Conexion();
    }

    public int getIdNota_Prestamo() {
        return idNota_Prestamo;
    }

    public void setIdNota_Prestamo(int idNota_Prestamo) {
        this.idNota_Prestamo = idNota_Prestamo;
    }

    public int getEmpleado_IdEmpleado() {
        return Empleado_IdEmpleado;
    }

    public void setEmpleado_IdEmpleado(int Empleado_IdEmpleado) {
        this.Empleado_IdEmpleado = Empleado_IdEmpleado;
    }

    public int getUsuario_IdUsuario() {
        return Usuario_IdUsuario;
    }

    public void setUsuario_IdUsuario(int Usuario_IdUsuario) {
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void GuardarNotaPrestamo(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into nota_prestamo values ("+String.valueOf(idNota_Prestamo)+","+String.valueOf(Empleado_IdEmpleado)+","+String.valueOf(Usuario_IdUsuario)+",'"+fecha+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA NOTA PRESTAMO");

       }
    
    }
    
   
    
    public void EliminarNota(){
       Statement Consulta;
       String dato ="delete from nota_prestamo where idNota_Prestamo="+String.valueOf(idNota_Prestamo)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla NOTA PRESTAMO");
       }
    }
    
   
    
}
