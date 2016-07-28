/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DFicha_Obra_Materiales;
import Dato.DStock;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosPc
 */
public class NFicha_Obra_Materiales {
        private DFicha_Obra_Materiales datoFicha;
        private DStock datoStock;
        
    public NFicha_Obra_Materiales() {
    datoFicha= new DFicha_Obra_Materiales();
    datoStock= new DStock();
    }
    
    public void setFicha_Obra(int notarecepcion,int idmateriales,String unidad,int cantidad){
    datoFicha.setIdFicha_Obra_Materiales(datoFicha.getCount()+1);
    datoFicha.setNotaRecepcion_idNotaRecepcion(notarecepcion);
    datoFicha.setMateriales_IdMaterial(idmateriales);
    datoFicha.setUnidad(unidad);
    datoFicha.setCantidad(cantidad);
    datoFicha.GuardarFichaObraMateriales();
    }
    

    
    
    public DefaultTableModel ListaTabla(){
        return datoFicha.MostrarTabla();
    }
}
