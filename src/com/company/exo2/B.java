package com.company.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class B extends Thread {
    private int Somme = 0;
    Socket socketVC;
    Socket socket;
    public B() {

    }
    public void run() {
        runServer(11001);
    }
    private void runServer(int i) {
        Object obj;
        try {
            sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int b = 0;
        try {
            socketVC  = new Socket("127.0.0.1",11087);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ServerSocket server_socket = new ServerSocket(i);
            socket = server_socket.accept();
            sendStartSignal();
            while(b<1000) {
                ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));
                try {
                    obj = in.readObject();
                    if (obj instanceof Signal) {
                        signal((Signal)obj);
                    }
                    else if (obj instanceof StopSignal) {
                        stopSocket();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            socket.close();
            socketVC.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopSocket() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendStartSignal() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socketVC.getOutputStream());
            StartSignal start = new StartSignal();
            out.writeObject(start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void signal(Signal obj) {
        Somme += obj.getN();
        if (Somme>1000) {

            try {
                ObjectOutputStream out = new ObjectOutputStream(socketVC.getOutputStream());
                Signal sig = new Signal(Somme);
                out.writeObject(sig);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Somme = 0;
        }
    }
}
