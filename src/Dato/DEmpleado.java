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
public class DEmpleado {
    Conexion con;
    int IdEmpleado;
    int Contratista_idContratista;
    String Nombres;
    String Apellidos;
    int Telefono;
    int Carnet_de_Identidad;
    String Direccion;
    String Cargo_IdCargo;

    public DEmpleado() {
        this.con =  new Conexion();
    }

    public DEmpleado(int IdEmpleado, int Contratista_idContratista, String Nombres, String Apellidos, int Telefono, int Carnet_de_Identidad, String Direccion, String Cargo_IdCargo) {
        this.IdEmpleado = IdEmpleado;
        this.Contratista_idContratista = Contratista_idContratista;
        this.Cargo_IdCargo = Cargo_IdCargo;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Carnet_de_Identidad = Carnet_de_Identidad;
        this.Direccion = Direccion;
    }

    

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getContratista_idContratista() {
        return Contratista_idContratista;
    }

    public void setContratista_idContratista(int Contratista_idContratista) {
        this.Contratista_idContratista = Contratista_idContratista;
    }

    public String getCargo_IdCargo() {
        return Cargo_IdCargo;
    }

    public void setCargo_IdCargo(String Cargo_IdCargo) {
        this.Cargo_IdCargo = Cargo_IdCargo;
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

    public int getCarnet_de_Identidad() {
        return Carnet_de_Identidad;
    }

    public void setCarnet_de_Identidad(int Carnet_de_Identidad) {
        this.Carnet_de_Identidad = Carnet_de_Identidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void GuardarEmpleado(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into empleado values ("+String.valueOf(IdEmpleado)+","+String.valueOf(Contratista_idContratista)+",'"+Nombres+"','"+Apellidos+"',"+String.valueOf(Telefono)+","+String.valueOf(Carnet_de_Identidad)+",'"+Direccion+"','"+Cargo_IdCargo+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA EMPLEADO");

       }
    
    }
    
    public void ModificarNombreApellidoEmpleado(){
       Statement Consulta;
       String dato ="update empleado set nombres='"+Nombres+"', apellidos='"+Apellidos+"' where IdEmpleado="+String.valueOf(IdEmpleado)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA EMPLEADO");

       }
    
    }
    
    public void EliminarEmpleado(){
       Statement Consulta;
       String dato ="delete from empleado where IdEmpleado="+String.valueOf(IdEmpleado)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla Empleado");
       }
    }
    
     public DefaultTableModel getTabla(){
        String[] columnNames = {"IdEmpleado","IdContratista","Nombres","Apellidos","Telefono","Carnet Identidad","Direccion","Cargo"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from empleado";

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
            System.out.println("no se pudo CARGAR LOS DATOS TABLA CONTRATISTA");
       } 
      
      return tabla;
    }

    public DefaultComboBoxModel getCombo() {
         DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from empleado";

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
     
    public LinkedList<DEmpleado> Buscar() {
      LinkedList<DEmpleado> l=new LinkedList<>();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from empleado";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                l.addLast(new DEmpleado(resultado.getInt(1), resultado.getInt(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getInt(6),resultado.getString(8),resultado.getString(3)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA EMPLEADO");
       } 
        return l;
    }

}
