/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class DFicha_Obra_Materiales {
       int idFicha_Obra_Materiales;
       int NotaRecepcion_idNotaRecepcion;
       int Materiales_IdMaterial;
       String unidad;
       int cantidad;

    Conexion con;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public DFicha_Obra_Materiales() {
        this.con =new  Conexion();
    }

    public int getNotaRecepcion_idNotaRecepcion() {
        return NotaRecepcion_idNotaRecepcion;
    }

    public void setNotaRecepcion_idNotaRecepcion(int NotaRecepcion_idNotaRecepcion) {
        this.NotaRecepcion_idNotaRecepcion = NotaRecepcion_idNotaRecepcion;
    }

    public int getMateriales_IdMaterial() {
        return Materiales_IdMaterial;
    }

    public void setMateriales_IdMaterial(int Materiales_IdMaterial) {
        this.Materiales_IdMaterial = Materiales_IdMaterial;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getIdFicha_Obra_Materiales() {
        return idFicha_Obra_Materiales;
    }

    public void setIdFicha_Obra_Materiales(int idFicha_Obra_Materiales) {
        this.idFicha_Obra_Materiales = idFicha_Obra_Materiales;
    }    
    
    public void GuardarFichaObraMateriales(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into ficha_obra_materiales values ("+String.valueOf(idFicha_Obra_Materiales)+","+String.valueOf(NotaRecepcion_idNotaRecepcion)+","+String.valueOf(Materiales_IdMaterial)+",'"+unidad+"',"+String.valueOf(cantidad)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA FICHA OBRA MATERIALES");

       }
    
    }
      
    public DefaultTableModel MostrarTabla(){
       String dato ="select f.idFicha_Obra_Materiales, nr.idNotaRecepcion,m.idmaterial, m.descripcion,m.marca,m.categoria,dr.unidad,f.cantidad from materiales m inner join detallerecepcion dr on m.idmaterial=dr.materiales_idmaterial inner join notarecepcion nr on nr.idNotaRecepcion=dr.NotaRecepcion_idNotaRecepcion inner join ficha_obra_materiales f on f.NotaRecepcion_idNotaRecepcion=nr.idNotaRecepcion and f.Materiales_IdMaterial=dr.materiales_idmaterial";
      String[] columnNames = {"Nro Ficha","Nro Nota Recepcion","Codigo Material","Descripcion","Marca","Categoria","Unidad","Pzas"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                tabla.setRowCount(tabla.getRowCount()+1);
                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultado.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultado.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultado.getObject(5).toString(), i, 4);
                tabla.setValueAt(resultado.getObject(6).toString(), i, 5);
                tabla.setValueAt(resultado.getObject(7).toString(), i, 6);
                tabla.setValueAt(resultado.getObject(8).toString(), i, 7);
                i++;
                
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA MATERIALES");
       }
      return tabla;
    }
    
    public int getCount(){
     Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato = "select count(*) from ficha_obra_materiales"; 
       int x=0;
       try {
           Consulta=(Statement) con.getConexion().createStatement();
         ResultSet resultado = Consulta.executeQuery(dato);
           while (resultado.next()) {
               x=resultado.getInt(1);
               
           }
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA FICHA OBRA MATERIALES");

       }
       return x;
    }
    
}
