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
public class DProveedor {
      int idProveedor;
  String Nombres;
  String Apellidos;
  String Empresa;
  int Telefono;
  Conexion con;

    public DProveedor(int idProveedor, String Nombres, String Apellidos, String Empresa, int Telefono) {
        this.idProveedor = idProveedor;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Empresa = Empresa;
        this.Telefono = Telefono;
    }

  
  
    public DProveedor() {
    this.con= new Conexion();
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
  
    public void GuardarProveedor(){
       Statement Consulta;
       
       
       String dato ="insert into proveedor values ("+String.valueOf(idProveedor)+",'"+Nombres+"','"+Apellidos+"','"+Empresa+"',"+String.valueOf(Telefono)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA PROVEEDOR");

       }
    
    }
    
      public void ModificarNombreApellidoProveedor(){
       Statement Consulta;
       String dato ="update proveedor set nombres='"+Nombres+"', apellidos='"+Apellidos+"' where idProveedor="+String.valueOf(idProveedor)+";";
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
       String dato ="delete from proveedor where idProveedor="+String.valueOf(idProveedor)+";";
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
        String[] columnNames = {"idProveedor","Nombres","Apellidos","Empresa","Telefono"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from proveedor";

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
            System.out.println("no se pudo CARGAR LOS DATOS TABLA PROVEEDOR");
       } 
      
      return tabla;
    }  
   
   
    public DefaultComboBoxModel getCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from proveedor";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                combo.addElement(resultado.getObject(2));
               // l.addLast(new DUsuario(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getString(6),resultado.getInt(7)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA PROVEEDOR");
       } 
      
      return combo;
    }
    
     public LinkedList<DProveedor> Buscar() {
      LinkedList<DProveedor> l=new LinkedList<>();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from proveedor";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                l.addLast(new DProveedor(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA PROVEEDOR");
       } 
      
     return l;
    }

}