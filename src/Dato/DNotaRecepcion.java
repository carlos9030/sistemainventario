/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarlosPc
 */
public class DNotaRecepcion {
    int idNotaRecepcion;
    int Proveedor_idProveedor;
    String Fecha;
    String Ingeniero_obra;
    int NotaRemision;
    String Transportista;
    int Obra_IdObra;
    Conexion con;

    public int getObra_IdObra() {
        return Obra_IdObra;
    }

    public void setObra_IdObra(int Obra_IdObra) {
        this.Obra_IdObra = Obra_IdObra;
    }
    

    public DNotaRecepcion() {
   this.con =new Conexion();
    }

    public int getIdNotaRecepcion() {
        return idNotaRecepcion;
    }

    public void setIdNotaRecepcion(int idNotaRecepcion) {
        this.idNotaRecepcion = idNotaRecepcion;
    }

    public int getProveedor_idProveedor() {
        return Proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(int Proveedor_idProveedor) {
        this.Proveedor_idProveedor = Proveedor_idProveedor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIngeniero_obra() {
        return Ingeniero_obra;
    }

    public void setIngeniero_obra(String Ingeniero_obra) {
        this.Ingeniero_obra = Ingeniero_obra;
    }

    public int getNotaRemision() {
        return NotaRemision;
    }

    public void setNotaRemision(int NotaRemision) {
        this.NotaRemision = NotaRemision;
    }

    public String getTransportista() {
        return Transportista;
    }

    public void setTransportista(String Transportista) {
        this.Transportista = Transportista;
    }
   

    public void Guardar() {
         Statement Consulta;
       String dato ="insert into notarecepcion values ("+String.valueOf(idNotaRecepcion)+","+String.valueOf(Obra_IdObra)+","+String.valueOf(Proveedor_idProveedor)+",'"+Fecha+"','"+Ingeniero_obra+"',"+String.valueOf(NotaRemision)+",'"+Transportista+"');";
      try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA NOTA RECEPCION MATERIALES");
       }
    }
}
