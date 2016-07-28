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
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class DUsuario {
    Conexion con;
    int IdUsuario;
    String Nombre_Completo;
    String Nick;
    String Contraseña;
    int Carnet_identidad;
    String Direccion;
    int Telefono;

    public DUsuario() {
        con=new Conexion();
    }

    private DUsuario(int id, String nombrecompleto, String nick, String contraseña, int ci, String direccion, int telefono) {
       this.IdUsuario=id;
       this.Nombre_Completo=nombrecompleto;
       this.Nick=nick;
       this.Contraseña=contraseña;
       this.Carnet_identidad=ci;
       this.Direccion=direccion;
       this.Telefono=telefono;
    }

 

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String Nombre_Completo) {
        this.Nombre_Completo = Nombre_Completo;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getCarnet_identidad() {
        return Carnet_identidad;
    }

    public void setCarnet_identidad(int Carnet_identidad) {
        this.Carnet_identidad = Carnet_identidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
     public void GuardarUsuario(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into Usuario values ("+String.valueOf(IdUsuario)+",'"+Nombre_Completo+"','"+Nick+"','"+Contraseña+"',"+String.valueOf(Carnet_identidad)+",'"+Direccion+"',"+String.valueOf(Telefono)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA USUARIO");

       }
    
    }
    
    public void ModificarNombre_CompletoUsuario(){
       Statement Consulta;
       String dato ="update usuario set nombre_completo='"+Nombre_Completo+"' where IdUsuario="+String.valueOf(IdUsuario)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA ");

       }
    
    }
    
    public void EliminarUsuario(){
       Statement Consulta;
       String dato ="delete from usuario where IdUsuario="+String.valueOf(IdUsuario)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla Usuario");
       }
    }
    
     public DefaultTableModel getTabla(){
        String[] columnNames = {"IdUsuario","Nombre_Completo","Nick","Contrasenha","Carnet_de_Identidad","Direccion","Telefono"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from usuario";

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
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA USUARIO");
       } 
      
      return tabla;
    }
     
         public int getFila() {

        Statement Consulta;
        ResultSet resultado = null;
        String dato = "select idusuario from usuario where nombre_completo='" + Nombre_Completo + "';";

        try {
            Consulta = (Statement) con.getConexion().createStatement();
            resultado = Consulta.executeQuery(dato);
            int i = 0;
            while (resultado.next()) {
                IdUsuario = Integer.valueOf(resultado.getObject(1).toString());
                i++;
            }
            Consulta.close();

        } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA USUARIO");
        }

        return IdUsuario;
    }

    public DefaultComboBoxModel getCombo() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from usuario";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                combo.addElement(resultado.getObject(2));
               // l.addLast(new DUsuario(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getString(6),resultado.getInt(7)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA USUARIO");
       } 
      
      return combo;
    }
    
    public LinkedList<DUsuario> Buscar() {
      LinkedList<DUsuario> l=new LinkedList<>();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from usuario";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                l.addLast(new DUsuario(resultado.getInt(1), resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5),resultado.getString(6),resultado.getInt(7)));
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA USUARIO");
       } 
      
     return l;
    }
     
    
}
