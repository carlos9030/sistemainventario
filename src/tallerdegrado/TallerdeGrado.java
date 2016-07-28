/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tallerdegrado;

import Dato.DNotaRecepcion;

/**
 *
 * @author CarlosPc
 */
public class TallerdeGrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DNotaRecepcion p= new DNotaRecepcion();
       p.setIdNotaRecepcion(1);
       p.setProveedor_idProveedor(1);
       p.setFecha("23/08/2016");
       p.setIngeniero_obra("Ingeniero Gueri Vargas");
       p.setNotaRemision(342);
        //p.ModificarNombreApellidoProveedor();
        //p.EliminarContratista();
    }
    
}
