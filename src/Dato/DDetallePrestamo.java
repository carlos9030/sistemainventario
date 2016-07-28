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
public class DDetallePrestamo {
    int Materiales_IdMaterial;
    int Nota_Prestamo_idNota_Prestamo;
    String Unidad;
    int Cantidad;
    String Tipo;
    Conexion con;

    public DDetallePrestamo() {
    this.con= new Conexion();
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
    }

    public int getNota_Prestamo_idNota_Prestamo() {
        return Nota_Prestamo_idNota_Prestamo;
    }

    public void setNota_Prestamo_idNota_Prestamo(int Nota_Prestamo_idNota_Prestamo) {
        this.Nota_Prestamo_idNota_Prestamo = Nota_Prestamo_idNota_Prestamo;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
     public void GuardarDetallePrestamo(){
           Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into detalle_prestamo values ("+String.valueOf(Materiales_IdMaterial)+","+String.valueOf(Nota_Prestamo_idNota_Prestamo)+",'"+Unidad+"',"+String.valueOf(Cantidad)+",'"+Tipo+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA DETALLE NOTA DE PRESTAMO");

       }
    }
}
