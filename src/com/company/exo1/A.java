package com.company.exo1;

import java.io.IOException;
import java.net.Socket;

public class A {
    public A() {

    }
    public static void Main() {
        try {
            Socket socket = new Socket("127.0.0.1",666);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
