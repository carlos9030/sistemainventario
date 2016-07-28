/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class DContratista {
     Conexion con;
    int IdContratista;
    String Nombres;
    String Apellidos;
    int Telefono;
    String Direccion;

    public DContratista(int IdContratista, String Nombres, String Apellidos, int Telefono, String Direccion) {
        this.IdContratista = IdContratista;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }
    

    public int getIdContratista() {
        return IdContratista;
    }

    public void setIdContratista(int IdContratista) {
        this.IdContratista = IdContratista;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public DContratista() {
        this.con = new Conexion();
    }
    
     
     public void GuardarContratista(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into Contratista values ("+String.valueOf(IdContratista)+",'"+Nombres+"','"+Apellidos+"',"+String.valueOf(Telefono)+",'"+Direccion+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA ONTRATISTA");

       }
    
    }
    
    public void ModificarNombreApellidoContratista(){
       Statement Consulta;
       String dato ="update contratista set nombres='"+Nombres+"', apellidos='"+Apellidos+"' where IdContratista="+String.valueOf(IdContratista)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA CONTRATISTA");

       }
    
    }
    
    public void EliminarContratista(){
       Statement Consulta;
       String dato ="delete from contratista where IdContratista="+String.valueOf(IdContratista)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla Contratista");
       }
    }
    
     public DefaultTableModel getTabla(){
        String[] columnNames = {"IdContratista","Nombres","Apellidos","Telefono","Direccion"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from contratista";

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
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA CONTRATISTA");
       } 
      
      return tabla;
    }  
   
       

    public DefaultComboBoxModel getCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from contratista";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                combo.addElement(resultado.getObject(2));
               // l.addLast(new DUsuario(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getString(6),resultado.getInt(7)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA CONTRATISTA");
       } 
      
      return combo;
    }
    
    public LinkedList<DContratista> Buscar() {
      LinkedList<DContratista> l=new LinkedList<>();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from contratista";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                l.addLast(new DContratista(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getInt(4),resultado.getString(5)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA CONTRATISTA");
       } 
      
     return l;
    }
    
     
}
