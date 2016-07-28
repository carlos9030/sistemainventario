package Dato;


import Dato.Conexion;
import Dato.DNotaPrestamo;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CarlosPc
 */
public class DStock {
    int Materiales_IdMateriales;
    int Ficha_Obra_Materiales_idFicha_Obra_Materiales;
    String Unidad;
    int Cantidad;
    Conexion con;

    public DStock() {
        this.con = new Conexion();
    }

    public int getMateriales_IdMateriales() {
        return Materiales_IdMateriales;
    }

    public void setMateriales_IdMateriales(int Materiales_IdMateriales) {
        this.Materiales_IdMateriales = Materiales_IdMateriales;
    }

    public int getFicha_Obra_Materiales_idFicha_Obra_Materiales() {
        return Ficha_Obra_Materiales_idFicha_Obra_Materiales;
    }

    public void setFicha_Obra_Materiales_idFicha_Obra_Materiales(int Ficha_Obra_Materiales_idFicha_Obra_Materiales) {
        this.Ficha_Obra_Materiales_idFicha_Obra_Materiales = Ficha_Obra_Materiales_idFicha_Obra_Materiales;
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
    
       public void GuardarStock(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into stock values ("+String.valueOf(Ficha_Obra_Materiales_idFicha_Obra_Materiales)+","+String.valueOf(Materiales_IdMateriales)+",'"+Unidad+"',"+String.valueOf(Cantidad)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA STOCK");

       }
    
    }
    
    public void ModificarStock(){
       Statement Consulta;
       String dato ="update stock set unidad='"+Unidad+"' where Obra_IdObra="+String.valueOf(Ficha_Obra_Materiales_idFicha_Obra_Materiales)+" and Materiales_IdMaterial="+String.valueOf(Materiales_IdMateriales)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA STOCK");

       }
    
    }
    
    public void EliminarItem(){
       Statement Consulta;
       String dato ="delete from stock where Obra_IdObra="+String.valueOf(Ficha_Obra_Materiales_idFicha_Obra_Materiales)+" and Materiales_IdMateriales="+String.valueOf(Materiales_IdMateriales)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla STOCK");
       }
    }
    
     
}
