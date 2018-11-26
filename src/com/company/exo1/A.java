package com.company.exo1;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class A extends Thread {
    public A() {

    }
    public void run() {
        int i = 0;
        try {

            Socket socket = new Socket("127.0.0.1",11001);
            while(i<1000) {
                try {
                    sleep(random(10,1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                if (random(0,1)==0) {
                    Top top = new Top();
                    out.writeObject(top);
                }
                else {
                    Tip tip = new Tip(random(0,10),random(0,10));
                    out.writeObject(tip);
                }


                //Signal sig = new Signal();
                //out.writeObject(sig);

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
