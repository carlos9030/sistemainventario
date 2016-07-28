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
public class DMateriales {
    Conexion con;
    int IdMaterial;
    int Categoria_IdCategoria;
    String Descripcion;
    String Marca;
    String Categoria;

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    
    
    public DMateriales() {
    con=new Conexion();
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
   public void GuardarMateriales(){
       Statement Consulta;
       //String dato ="insert into genero values ("+String.valueOf(nro)+",'"+nombre+"');";
       String dato ="insert into materiales values ("+String.valueOf(IdMaterial)+",'"+Descripcion+"','"+Marca+"','"+Categoria+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAR TABLA MATERIALES");

       }
    
    }
    
    public void ModificarDescripcionMateriales(){
       Statement Consulta;
       String dato ="update materiales set descripcion='"+Descripcion+"' where IdMaterial="+String.valueOf(IdMaterial)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA MATERIALES");

       }
    
    }
    
    public void EliminarMaterial(){
       Statement Consulta;
       String dato ="delete from materiales where IdMaterial="+String.valueOf(IdMaterial)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
       System.out.println(e.getMessage());
           System.out.println("no se pudo eliminar en la tabla MATERIALES");
       }
    }
    
     public DefaultTableModel getTabla(){
        String[] columnNames = {"IdMaterial","Descripcion","Marca","Categoria"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from materiales";

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
            System.out.println("no se pudo CARGAR LOS DATOS TABLA MATERIALES");
       }
      return tabla;
    }  
      
     
}

