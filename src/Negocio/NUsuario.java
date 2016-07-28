/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DUsuario;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NUsuario {
        private DUsuario DatoUsuario;

    public NUsuario() {
    DatoUsuario = new DUsuario();
    }
    
    public void setUsuario(int IdUsuario,String nombrecompleto,String nick,String contraseña,int ci,String direccion,int telefono){
        DatoUsuario.setIdUsuario(IdUsuario);
        DatoUsuario.setNombre_Completo(nombrecompleto);
        DatoUsuario.setNick(nick);
        DatoUsuario.setContraseña(contraseña);
        DatoUsuario.setCarnet_identidad(ci);
        DatoUsuario.setTelefono(telefono);
        DatoUsuario.setDireccion(direccion);
        DatoUsuario.GuardarUsuario();
    }
    
    public DefaultTableModel getUsuario(){
        return DatoUsuario.getTabla();
    }
 
       public DefaultComboBoxModel ListarCombo(){
        return DatoUsuario.getCombo();
    }
    
    public void Modificar(int IdUsuario,String nombrecompleto){
        DatoUsuario.setIdUsuario(IdUsuario);
        DatoUsuario.setNombre_Completo(nombrecompleto);
        DatoUsuario.ModificarNombre_CompletoUsuario();
    }
    
    public void Eliminar(int IdUsuario){
        DatoUsuario.setIdUsuario(IdUsuario);
        DatoUsuario.EliminarUsuario();
    }
    
    public int BuscarId(String nombrecompleto){
        LinkedList <DUsuario> l= new LinkedList<>();
        l=DatoUsuario.Buscar();
        int x=0;
           int i=0;
           while (i<l.size()) {
            if(l.get(i).getNombre_Completo().equals(nombrecompleto)){
            x= l.get(i).getIdUsuario();
            }
            i++;
            
        } 
           return x;
    }
    
    
    
   
}
