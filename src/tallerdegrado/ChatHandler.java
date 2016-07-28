/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tallerdegrado;


import java.io.*;
import java.net.Socket;
import java.util.*;
/**
 *
 * @author CarlosPc
 */
class ChatHandler extends Thread{
    
    protected Socket s;
    protected DataInputStream i;
    protected DataOutputStream o;
    protected String host;
            
    ChatHandler(Socket client) throws IOException {
       this.s=client;
       i=new DataInputStream(new BufferedInputStream(s.getInputStream()));
       o=new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
       
    }
    
    protected static Vector Handlers = new Vector();
    
    public void run(){
        String name= s.getInetAddress().toString();
        try {
            System.out.println("Se ha unido: " + name);
        broadcast (name + " has joined ",name );
        this.host=name;
        Handlers.addElement(this);
            while (true) {            
                String msg= i.readUTF();
                System.out.println("Mensaje recibido "+ msg);
                broadcast (name + "  -  " + msg,name ); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
                    Handlers.removeElement(this);
                     broadcast (name + "  -  " ,name ); 
                     try {
                            s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
       
        }
    

    protected static void broadcast(String mensaje , String hostqueenvia){
           synchronized(Handlers){
             Enumeration ec=  Handlers.elements();
                while(ec.hasMoreElements()){
                    ChatHandler c= (ChatHandler) ec.nextElement();
                    System.out.println("Envia.... " +hostqueenvia+ " Se une " + c.host );
                    try {
                       synchronized(c.o){
                           c.o.writeUTF(mensaje);
                       } 
                       c.o.flush();
                    } catch (Exception e) {
                    c.stop();
                    }
                }
           }
    
    }
    
    
}
