package com.company.exo2;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class A extends Thread {
    private int adresse;
    public A(int i) {
        adresse = i;
    }
    public void run() {
        int i = 0;
        try {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Socket socket = new Socket("127.0.0.1",adresse);
            while(i<1000) {
                try {
                    sleep(random(1,100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                Signal sig = new Signal(random(0,100));
                out.writeObject(sig);

                i ++;
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int random(int i, int a) {
        return (int) (Math.round(Math.random()*a)+i);
    }
}
