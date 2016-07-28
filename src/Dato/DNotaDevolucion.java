/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CarlosPc
 */
public class DNotaDevolucion {
 int idNotaDevolucion;
 int Empleado_IdEmpleado;
 int Usuario_IdUsuario;
 String Fecha;
 Conexion con;

    public DNotaDevolucion() {
       con = new Conexion();
    }

    public int getIdNotaDevolucion() {
        return idNotaDevolucion;
    }

    public void setIdNotaDevolucion(int idNotaDevolucion) {
        this.idNotaDevolucion = idNotaDevolucion;
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
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
 
    public void GuardarNotaDevolucion(){
     Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into notadevolucion values ("+String.valueOf(idNotaDevolucion)+","+String.valueOf(Empleado_IdEmpleado)+","+String.valueOf(Usuario_IdUsuario)+",'"+Fecha+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (SQLException e) {
           System.out.println("no se puede GUARDAT TABLA NOTA DE DEVOLUCION ");

       }
    }
}
