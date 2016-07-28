/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DDetallePedido;
import Dato.DNotaPedido;

/**
 *
 * @author CarlosPc
 */
public class NNotaPedido {
    DNotaPedido datonotapedido;
    DDetallePedido datodetpedido;

    public NNotaPedido() {
    this.datonotapedido= new DNotaPedido();
    this.datodetpedido= new DDetallePedido();
    }
    
    public void setNota_Pedido(int idNota,int idObra, String Observacion, String fecha, String IngenieroObra){
   datonotapedido.setIdNotaPedido(idNota);
   datonotapedido.setObra_IdObra(idObra);
   datonotapedido.setIngeniero_obra(IngenieroObra);
   datonotapedido.setFecha(fecha);
   datonotapedido.setObservacion(Observacion);
   datonotapedido.GuardarNotaPedido();
    }
    
   public void setDDetallePedido(String unidad, int idMateriales,int idNotaPedido, int cantidad){
     datodetpedido.setNotaPedido_idNotaPedido(idNotaPedido);
     datodetpedido.setMateriales_IdMaterial(idMateriales);
     datodetpedido.setUnidad(unidad);
     datodetpedido.setCantidad(cantidad);
     datodetpedido.GuardarDetallePedido();
    }
    
    
}