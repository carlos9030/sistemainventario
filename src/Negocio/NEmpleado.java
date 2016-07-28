/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DEmpleado;
import java.util.LinkedList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NEmpleado {
         private DEmpleado datoEmpleado;

    public NEmpleado() {
    datoEmpleado= new DEmpleado();
    }
    
    
    
    public DefaultTableModel ListaTabla(){
        return datoEmpleado.getTabla();
    }
    
    public void setEmpleado(int idEmpleado,int idContratista,String IdCargo,String nombre,String apellidos,int telefono,int ci,String direccion){
     datoEmpleado.setIdEmpleado(idEmpleado);
     datoEmpleado.setCargo_IdCargo(IdCargo);
     datoEmpleado.setContratista_idContratista(idContratista);
     datoEmpleado.setNombres(nombre);
     datoEmpleado.setApellidos(apellidos);
     datoEmpleado.setCarnet_de_Identidad(ci);
     datoEmpleado.setTelefono(telefono);
     datoEmpleado.setDireccion(direccion);
    
     datoEmpleado.GuardarEmpleado();
    }
    
    
    
    public void ModificarNombreApellido(int idEmpleado,String nombres, String apellidos){
     datoEmpleado.setIdEmpleado(idEmpleado);
     datoEmpleado.setNombres(nombres);
     datoEmpleado.setApellidos(apellidos);
     datoEmpleado.ModificarNombreApellidoEmpleado();
    }
    
    
    public void EliminarEmpleado(int idEmpleado){
        datoEmpleado.setIdEmpleado(idEmpleado);
        datoEmpleado.EliminarEmpleado();
    }

    public DefaultComboBoxModel ListarCombo() {
      return datoEmpleado.getCombo();
    }
    
     public int BuscarId(String descString){
        LinkedList <DEmpleado> l= new LinkedList<>();
        l=datoEmpleado.Buscar();
        int x=0;
           int i=0;
           while (i<l.size()) {
            if(l.get(i).getNombres().equals(descString)){
               return l.get(i).getIdEmpleado();
            }
            i++;
            
        } 
           return 0;
    }
}
