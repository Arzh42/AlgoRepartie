package com.company.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C extends Thread {
    private Socket backSocket;
    private int compteur = 0;
    private Socket socket;
    public C() {

    }
    public void run() {
        Object obj;

        try {
            ServerSocket server_socket = new ServerSocket(11087);
            socket = server_socket.accept();
            while(true) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                try {
                    obj = in.readObject();
                    if (obj instanceof StartSignal) {
                        backSocket  = new Socket("127.0.0.1",11001);
                        sendStopSignal();
                    }
                    else if (obj instanceof Signal) {
                        signal((Signal)obj);
                    }
                    else if (obj instanceof StopSignal) {
                        backSocket.close();
                        socket.close();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void signal(Signal sig) {
        System.out.println(compteur);
        compteur ++;
        if (compteur>1) {
            sendStopSignal();
        }
        System.out.println(sig.getN());
    }
    private void sendStopSignal() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(backSocket.getOutputStream());
            StopSignal stop = new StopSignal();
            out.writeObject(stop);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
