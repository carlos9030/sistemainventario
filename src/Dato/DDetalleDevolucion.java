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
public class DDetalleDevolucion {
    int Materiales_IdMaterial;
    int NotaDevolucion_idNotaDevolucion;
    String Unidad;
    int Cantidad;
    String Estado;
    Conexion con;

    public DDetalleDevolucion() {
        con= new Conexion();
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
    }

    public int getNotaDevolucion_idNotaDevolucion() {
        return NotaDevolucion_idNotaDevolucion;
    }

    public void setNotaDevolucion_idNotaDevolucion(int NotaDevolucion_idNotaDevolucion) {
        this.NotaDevolucion_idNotaDevolucion = NotaDevolucion_idNotaDevolucion;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
       public void GuardarDetalleDevolucion(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into detalledevolucion values ("+String.valueOf(Materiales_IdMaterial)+","+String.valueOf(NotaDevolucion_idNotaDevolucion)+",'"+Unidad+"',"+String.valueOf(Cantidad)+",'"+Estado+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (SQLException e) {
           System.out.println("no se puede GUARDAR TABLA DETALLE DEVOLUCION");

       }
    
    }
    
    
}
