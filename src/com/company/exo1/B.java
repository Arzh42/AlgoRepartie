package com.company.exo1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class B extends Thread {
    public B() {

    }
    public void run() {
        Object obj;
        try {
            ServerSocket server_socket = new ServerSocket(11001);
            Socket socket = server_socket.accept();
            while(true) {
                ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));
                try {
                    obj = in.readObject();
                    if (obj instanceof Signal) {
                        signal((Signal) obj);
                    }
                    else if (obj instanceof Tip) {
                        tip((Tip)obj);
                    }
                    else {
                        top((Top)obj);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void tip(Tip obj) {
        System.out.println("Tip reçu avec n="+obj.getN()+" x="+obj.getX());
    }
    private void top(Top obj) {
        System.out.println("Top reçu");
    }

    private void signal(Signal obj) {
        System.out.println("Message" + obj.toString());
    }
}
