/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tallerdegrado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;
import java.util.*;
/**
 *
 * @author CarlosPc
 */
public class ChatServer {

    public ChatServer(int port) throws IOException {
        ServerSocket server= new ServerSocket(port);
        while(true){
            Socket client = server.accept();
            System.out.println("Accepted from" + client.getInetAddress());
            ChatHandler c= new ChatHandler(client);
            c.start();
        }
    }
    
    public static void main(String[] args) throws IOException {
        new ChatServer(9831);
    }
    
}
