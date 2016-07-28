/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class DObra {
    Conexion con;
    int IdObra;
    int Usuario_IdUsuario;
    String Descripcion;
    String Direccion;
    
    public int getUsuario_IdUsuario() {
        return Usuario_IdUsuario;
    }

    public void setUsuario_IdUsuario(int Usuario_IdUsuario) {
        this.Usuario_IdUsuario = Usuario_IdUsuario;
    }
  
     public DObra(int IdObra, int Usuario_IdUsuario, String Descripcion, String Direccion) {
        this.IdObra = IdObra;
        this.Usuario_IdUsuario = Usuario_IdUsuario;
        this.Descripcion = Descripcion;
        this.Direccion = Direccion;
    }
    
    public DObra() {
        con = new Conexion();
    }

    public int getIdObra() {
        return IdObra;
    }

    public void setIdObra(int IdObra) {
        this.IdObra = IdObra;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    } 
    
    public void GuardarObra(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into obra values ("+String.valueOf(IdObra)+","+String.valueOf(Usuario_IdUsuario)+",'"+Descripcion+"','"+Direccion+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA OBRA");

       }
    
    }
    
     public DefaultComboBoxModel getCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from obra";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                combo.addElement(resultado.getObject(3));
               // l.addLast(new DUsuario(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getString(6),resultado.getInt(7)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA OBRA");
       } 
      
      return combo;
    }
    
    public void ModificarDescripcionObra(){
       Statement Consulta;
       String dato ="update obra set descripcion='"+Descripcion+"' where IdObra="+String.valueOf(IdObra)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA GENERO");

       }
    
    }
    
    public void EliminarObra(){
       Statement Consulta;
       String dato ="delete from obra where IdObra="+String.valueOf(IdObra)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla GENERO");
       }
    }
    
     public DefaultTableModel getTabla(){
        String[] columnNames = {"IdObra","Usuario","Descripcion","Direccion"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from obra";

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
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA GENERO");
       } 
      
      return tabla;
    }
     
        public LinkedList<DObra> Buscar() {
      LinkedList<DObra> l=new LinkedList<>();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from obra";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                
                l.addLast(new DObra(resultado.getInt(1), resultado.getInt(2),resultado.getString(3),resultado.getString(4)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA OBRA");
       } 
      
     return l;
    }
 
   
    
    
}
