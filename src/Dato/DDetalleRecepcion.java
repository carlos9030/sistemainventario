/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.Statement;

/**
 *
 * @author CarlosPc
 */
public class DDetalleRecepcion {
  int Materiales_IdMaterial;
    int NotaRecepcion_idNotaRecepcion;
    String Unidad;
    int Cantidad;
    Conexion con;

    public DDetalleRecepcion() {
    this.con =new Conexion();
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
    }

    public int getNotaRecepcion_idNotaRecepcion() {
        return NotaRecepcion_idNotaRecepcion;
    }

    public void setNotaRecepcion_idNotaRecepcion(int NotaRecepcion_idNotaRecepcion) {
        this.NotaRecepcion_idNotaRecepcion = NotaRecepcion_idNotaRecepcion;
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
    
    public void GuardarDetalleRecepcion(){
           Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into detallerecepcion values ("+String.valueOf(Materiales_IdMaterial)+","+String.valueOf(NotaRecepcion_idNotaRecepcion)+","+String.valueOf(Cantidad)+",'"+Unidad+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA DETALLE FICHA OBRA MATERIALES");

       }
    }
  
}
