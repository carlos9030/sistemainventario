/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DDetallePrestamo;
import Dato.DNotaPrestamo;

/**
 *
 * @author CarlosPc
 */
public class NNotaPrestamo {
    DNotaPrestamo notaprestamo;
    DDetallePrestamo detalleprestamo;

    public NNotaPrestamo() {
    notaprestamo=new DNotaPrestamo();
    detalleprestamo= new DDetallePrestamo();
    }
    
    
    
    public void setNota_Prestamo(int idFicha, int idEmpleado,int idUsuario, String fecha){
    notaprestamo.setIdNota_Prestamo(idFicha);
    notaprestamo.setUsuario_IdUsuario(idUsuario);
    notaprestamo.setEmpleado_IdEmpleado(idEmpleado);
    notaprestamo.setFecha(fecha);
    notaprestamo.GuardarNotaPrestamo();
    }
    
    
    public void setDDetallePrestamo(int idMateriales,int idNotaPrestamo, String unidad, int cantidad,String tipo){
     detalleprestamo.setNota_Prestamo_idNota_Prestamo(idNotaPrestamo);
     detalleprestamo.setMateriales_IdMaterial(idMateriales);
     detalleprestamo.setUnidad(unidad);
     detalleprestamo.setCantidad(cantidad);
     detalleprestamo.setTipo(tipo);
     detalleprestamo.GuardarDetallePrestamo();
    }
}
