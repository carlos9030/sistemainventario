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
public class DDetalleSalida {
        int Materiales_IdMaterial;
        int SalidaMateriales_idSalidaMateriales;
        String Unidad;
        int Cantidad;
        Conexion con;
    
    public DDetalleSalida() {
        con= new Conexion();
    }

    public DDetalleSalida(int Materiales_IdMaterial, int SalidaMateriales_idSalidaMateriales, String Unidad, int Cantidad) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
        this.SalidaMateriales_idSalidaMateriales = SalidaMateriales_idSalidaMateriales;
        this.Unidad = Unidad;
        this.Cantidad = Cantidad;
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
    }

    public int getSalidaMateriales_idSalidaMateriales() {
        return SalidaMateriales_idSalidaMateriales;
    }

    public void setSalidaMateriales_idSalidaMateriales(int SalidaMateriales_idSalidaMateriales) {
        this.SalidaMateriales_idSalidaMateriales = SalidaMateriales_idSalidaMateriales;
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
    
    public void GuardarDetalleSalida(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into detallesalida values ("+String.valueOf(Materiales_IdMaterial)+","+String.valueOf(SalidaMateriales_idSalidaMateriales)+",'"+Unidad+"',"+String.valueOf(Cantidad)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA DETALLE PEDIDO");

       }
    
    }
    
}
