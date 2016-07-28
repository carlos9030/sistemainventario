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
public class DNotaSalida {
    int idSalidaMateriales;
    int Obra_IdObra;
    String ObraDestino;
    String Transportista;
    String Fecha;
    Conexion con;

    public DNotaSalida() {
        con= new Conexion();
    }

    public DNotaSalida(int idSalidaMateriales, int Obra_IdObra, String ObraDestino, String Transportista, String Fecha) {
        this.idSalidaMateriales = idSalidaMateriales;
        this.Obra_IdObra = Obra_IdObra;
        this.ObraDestino = ObraDestino;
        this.Transportista = Transportista;
        this.Fecha = Fecha;
    }

    public int getIdSalidaMateriales() {
        return idSalidaMateriales;
    }

    public void setIdSalidaMateriales(int idSalidaMateriales) {
        this.idSalidaMateriales = idSalidaMateriales;
    }

    public int getObra_IdObra() {
        return Obra_IdObra;
    }

    public void setObra_IdObra(int Obra_IdObra) {
        this.Obra_IdObra = Obra_IdObra;
    }

    public String getObraDestino() {
        return ObraDestino;
    }

    public void setObraDestino(String ObraDestino) {
        this.ObraDestino = ObraDestino;
    }

    public String getTransportista() {
        return Transportista;
    }

    public void setTransportista(String Transportista) {
        this.Transportista = Transportista;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    public void GuardarNotaSalida(){
     Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into salidamateriales values ("+String.valueOf(idSalidaMateriales)+","+String.valueOf(Obra_IdObra)+",'"+ObraDestino+"','"+Transportista+"','"+Fecha+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA NOTA DE RECEPCION");

       }
    }
    
}
