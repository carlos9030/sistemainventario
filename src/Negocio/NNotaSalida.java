/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DDetalleSalida;
import Dato.DNotaSalida;

/**
 *
 * @author CarlosPc
 */
public class NNotaSalida {
    private DDetalleSalida datodetallesalida;
    private DNotaSalida datonotasalida;

    public NNotaSalida() {
    this.datodetallesalida= new DDetalleSalida();
    this.datonotasalida= new DNotaSalida();
    }
    
    public void setNotaSalida(int notasalida, int obrasalida, String obradestino, String transportista, String fecha){
    datonotasalida.setIdSalidaMateriales(notasalida);
    datonotasalida.setObra_IdObra(obrasalida);
    datonotasalida.setObraDestino(obradestino);
    datonotasalida.setTransportista(transportista);
    datonotasalida.setFecha(fecha);
    datonotasalida.GuardarNotaSalida();
    }
    
    public void setDetalleSalida(int notasalida, int idmateriales, String unidad, int cantidad){
    datodetallesalida.setSalidaMateriales_idSalidaMateriales(notasalida);
    datodetallesalida.setMateriales_IdMaterial(idmateriales);
    datodetallesalida.setUnidad(unidad);
    datodetallesalida.setCantidad(cantidad);
    datodetallesalida.GuardarDetalleSalida();
    }
    
}
