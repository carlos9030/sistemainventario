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
public class DNotaPedido {
    int idNotaPedido;
    int Obra_IdObra;
    String Observacion;
    String Ingeniero_obra;
    String Fecha;
    Conexion con;

    public DNotaPedido() {
        con= new Conexion();
    }

    public DNotaPedido(int idNotaPedido, int Obra_IdObra, String Observacion, String Ingeniero_obra, String Fecha) {
        this.idNotaPedido = idNotaPedido;
        this.Obra_IdObra = Obra_IdObra;
        this.Observacion = Observacion;
        this.Ingeniero_obra = Ingeniero_obra;
        this.Fecha = Fecha;
    }

    public int getIdNotaPedido() {
        return idNotaPedido;
    }

    public void setIdNotaPedido(int idNotaPedido) {
        this.idNotaPedido = idNotaPedido;
    }

    public int getObra_IdObra() {
        return Obra_IdObra;
    }

    public void setObra_IdObra(int Obra_IdObra) {
        this.Obra_IdObra = Obra_IdObra;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getIngeniero_obra() {
        return Ingeniero_obra;
    }

    public void setIngeniero_obra(String Ingeniero_obra) {
        this.Ingeniero_obra = Ingeniero_obra;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    public void GuardarNotaPedido(){
     Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into notapedido values ("+String.valueOf(idNotaPedido)+","+String.valueOf(Obra_IdObra)+",'"+Observacion+"','"+Ingeniero_obra+"','"+Fecha+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA NOTA DE PEDIDO");

       }
    }
    
}
