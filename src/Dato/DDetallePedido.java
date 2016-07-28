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
public class DDetallePedido{
    int Materiales_IdMaterial;
    int NotaPedido_idNotaPedido;
    String Unidad;
    int Cantidad;
      Conexion con;

    public DDetallePedido(int Materiales_IdMaterial, int NotaPedido_idNotaPedido, String Unidad, int Cantidad) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
        this.NotaPedido_idNotaPedido = NotaPedido_idNotaPedido;
        this.Unidad = Unidad;
        this.Cantidad = Cantidad;
    }

    public int getNotaPedido_idNotaPedido() {
        return NotaPedido_idNotaPedido;
    }

    public void setNotaPedido_idNotaPedido(int NotaPedido_idNotaPedido) {
        this.NotaPedido_idNotaPedido = NotaPedido_idNotaPedido;
    }
  

    public DDetallePedido() {
     con=new  Conexion();
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
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

    
      public void GuardarDetallePedido(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into detalle_pedido values ('"+Unidad+"',"+String.valueOf(Materiales_IdMaterial)+","+String.valueOf(NotaPedido_idNotaPedido)+","+String.valueOf(Cantidad)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA DETALLE PEDIDO");

       }
    
    }
    
  
    
    public void EliminarItem(){
       Statement Consulta;
       String dato ="delete from detalle_prestamo where Nota_Prestamo_idNota_Prestamo="+String.valueOf(NotaPedido_idNotaPedido)+" and Materiales_IdMaterial="+String.valueOf(Materiales_IdMaterial)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla Detalle Prestamo");
       }
    }
    
    
    
    
}
