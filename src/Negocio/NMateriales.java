/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DMateriales;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NMateriales {
       private DMateriales datoMateriales;

    public NMateriales() {
    datoMateriales= new DMateriales();
    }
    
    
    
    public DefaultTableModel ListaTabla(){
        return datoMateriales.getTabla();
    }
    
    public void setMateriales(int idMateriales,String idCategoria,String descripcion,String marca){
     datoMateriales.setIdMaterial(idMateriales);
     datoMateriales.setCategoria(idCategoria);
     datoMateriales.setDescripcion(descripcion);
     datoMateriales.setMarca(marca);
     datoMateriales.GuardarMateriales();
    }
    
    
    
    public void ModificarMateriales(int idMateriales,String descripcion){
     datoMateriales.setIdMaterial(idMateriales);
     datoMateriales.setDescripcion(descripcion);
     datoMateriales.ModificarDescripcionMateriales();
    }
    
    
    public void EliminarMateriales(int idMateriales){
        datoMateriales.setIdMaterial(idMateriales);
        datoMateriales.EliminarMaterial();
    }
}
