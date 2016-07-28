/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DNotaRecepcion;
import Dato.DDetalleRecepcion;

/**
 *
 * @author CarlosPc
 */
public class NNotaRecepcion {
     private DNotaRecepcion datoRecepcion;
        private DDetalleRecepcion datoDetalleRecepcion;
        
    public NNotaRecepcion() {
    datoRecepcion= new DNotaRecepcion();
    datoDetalleRecepcion= new DDetalleRecepcion();
    }
    
    public void setNota_Recepcion(int idFicha,int idObra, int idProveedor, String fecha, String ingenierobra, int notaremision, String Transportista){
    datoRecepcion.setIdNotaRecepcion(idFicha);
    datoRecepcion.setProveedor_idProveedor(idProveedor);
    datoRecepcion.setTransportista(Transportista);
    datoRecepcion.setFecha(fecha);
    datoRecepcion.setIngeniero_obra(ingenierobra);
    datoRecepcion.setNotaRemision(notaremision);
    datoRecepcion.setObra_IdObra(idObra);
    datoRecepcion.Guardar();
    }
    
    
    public void setDDetalle_Ficha(int idNotaRecepcion, int idMateriales, String unidad, int cantidad){
     datoDetalleRecepcion.setNotaRecepcion_idNotaRecepcion(idNotaRecepcion);
     datoDetalleRecepcion.setMateriales_IdMaterial(idMateriales);
     datoDetalleRecepcion.setUnidad(unidad);
     datoDetalleRecepcion.setCantidad(cantidad);
     datoDetalleRecepcion.GuardarDetalleRecepcion();
    }
    
}
