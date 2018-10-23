package com.company.exo1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class B extends Thread {
    public B() {

    }
    public void run() {
        try {
            ServerSocket server_socket = new ServerSocket(11001);
            Socket socket = server_socket.accept();
            while(true) {
                ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));
                Signal sigServer = null;
                try {
                    sigServer = (Signal) in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Message" + sigServer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
