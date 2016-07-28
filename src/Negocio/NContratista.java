/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DContratista;
import Dato.DUsuario;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NContratista {
       private DContratista DatoContratista;

    public NContratista() {
    DatoContratista = new DContratista();
    }
    public void setContratista(int IdContratista,String nombres,String apellidos,int telefono,String direccion){
        DatoContratista.setIdContratista(IdContratista);
        DatoContratista.setNombres(nombres);
        DatoContratista.setApellidos(apellidos);
        DatoContratista.setTelefono(telefono);
        DatoContratista.setDireccion(direccion);
        DatoContratista.GuardarContratista();
    }
    
    public DefaultTableModel getContratista(){
        return DatoContratista.getTabla();
    }
 
       public DefaultComboBoxModel ListarCombo(){
        return DatoContratista.getCombo();
    }
    
    
    public void Modificar(int IdContratista,String nombres,String apellidos){
        DatoContratista.setIdContratista(IdContratista);
        DatoContratista.setNombres(nombres);
        DatoContratista.setApellidos(apellidos);
        DatoContratista.ModificarNombreApellidoContratista();
    }
    
    public void Eliminar(int IdContratista){
        DatoContratista.setIdContratista(IdContratista);
        DatoContratista.EliminarContratista();
    }
    
     public int BuscarId(String nombrecompleto){
        LinkedList <DContratista> l= new LinkedList<>();
        l=DatoContratista.Buscar();
        int x=0;
           int i=0;
           while (i<l.size()) {
            if(l.get(i).getNombres().equals(nombrecompleto)){
            x= l.get(i).getIdContratista();
            }
            i++;
            
        } 
           return x;
    }
}
