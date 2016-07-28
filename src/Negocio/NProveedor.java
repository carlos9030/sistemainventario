/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DObra;
import Dato.DProveedor;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NProveedor {
     private DProveedor DatoProveedor;

    public NProveedor() {
    DatoProveedor = new DProveedor();
    }
    public void setProveedor(int IdProveedor,String nombres,String apellidos,int telefono,String empresa){
        DatoProveedor.setIdProveedor(IdProveedor);
        DatoProveedor.setNombres(nombres);
        DatoProveedor.setApellidos(apellidos);
        DatoProveedor.setTelefono(telefono);
        DatoProveedor.setEmpresa(empresa);
        DatoProveedor.GuardarProveedor();
    }
    
    public DefaultTableModel getProveedor(){
        return DatoProveedor.getTabla();
    }
 
       public DefaultComboBoxModel ListarCombo(){
        return DatoProveedor.getCombo();
    }
    
    
    public void Modificar(int IdContratista,String nombres,String apellidos){
        DatoProveedor.setIdProveedor(IdContratista);
        DatoProveedor.setNombres(nombres);
        DatoProveedor.setApellidos(apellidos);
        DatoProveedor.ModificarNombreApellidoProveedor();
    }
    
    public void Eliminar(int IdProveedor){
        DatoProveedor.setIdProveedor(IdProveedor);
        DatoProveedor.EliminarContratista();
    }
    
     public int BuscarId(String descString){
        LinkedList <DProveedor> l= new LinkedList<>();
        l=DatoProveedor.Buscar();
        int x=0;
           int i=0;
           while (i<l.size()) {
            if(l.get(i).getNombres().equals(descString)){
               return l.get(i).getIdProveedor();
            }
            i++;
            
        } 
           return 0;
    }
    
}
