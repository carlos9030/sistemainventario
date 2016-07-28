/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Dato.DDetalleDevolucion;
import Dato.DNotaDevolucion;

/**
 *
 * @author CarlosPc
 */
public class NNotaDevolucion {
    DNotaDevolucion datoDevolucion;
    DDetalleDevolucion datoDetDev;

    public NNotaDevolucion() {
        datoDetDev= new DDetalleDevolucion();
        datoDevolucion= new DNotaDevolucion();
    }
    
    public void setNotaDevulucion( int idNotaDevolucion,int Empleado_IdEmpleado,int Usuario_IdUsuario,String Fecha){
    datoDevolucion.setIdNotaDevolucion(idNotaDevolucion);
    datoDevolucion.setEmpleado_IdEmpleado(Empleado_IdEmpleado);
    datoDevolucion.setUsuario_IdUsuario(Usuario_IdUsuario);
    datoDevolucion.setFecha(Fecha);
    datoDevolucion.GuardarNotaDevolucion();
    }
    
    public void setDetalleDevolucion(int Materiales_IdMaterial, int NotaDevolucion_idNotaDevolucion,String Unidad, int Cantidad, String Estado){
    datoDetDev.setMateriales_IdMaterial(Materiales_IdMaterial);
    datoDetDev.setCantidad(Cantidad);
    datoDetDev.setEstado(Estado);
    datoDetDev.setNotaDevolucion_idNotaDevolucion(NotaDevolucion_idNotaDevolucion);
    datoDetDev.setUnidad(Unidad);
    datoDetDev.GuardarDetalleDevolucion();
    }
    
}
