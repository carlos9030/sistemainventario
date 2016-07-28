/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DContratista;
import Dato.DObra;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NObra {
      private DObra datoObra;

    public NObra() {
    datoObra= new DObra();
    }
    
    public DefaultComboBoxModel ListarCombo(){
        return datoObra.getCombo();
    }
    
    public DefaultTableModel ListaTabla(){
        return datoObra.getTabla();
    }
    
    public void setObra(int idObra,int idusuario,String descripcion,String direccion){
     datoObra.setIdObra(idObra);
     datoObra.setDescripcion(descripcion);
     datoObra.setDireccion(direccion);
     datoObra.setUsuario_IdUsuario(idusuario);
     datoObra.GuardarObra();
    }
    
    
    
    public void ModificarObra(int idObra,String descripcion){
     datoObra.setIdObra(idObra);
     datoObra.setDescripcion(descripcion);
     datoObra.ModificarDescripcionObra();
    }
    
    
    public void EliminarObra(int idObra){
        datoObra.setIdObra(idObra);
        datoObra.EliminarObra();
    }
    
    public int BuscarId(String descString){
        LinkedList <DObra> l= new LinkedList<>();
        l=datoObra.Buscar();
        int x=0;
           int i=0;
           while (i<l.size()) {
            if(l.get(i).getDescripcion().equals(descString)){
               return l.get(i).getIdObra();
            }
            i++;
            
        } 
           return 0;
    }
    
}
