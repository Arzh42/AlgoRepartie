package com.company.exo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class B {
    public B() {

    }
    public static void Main() {
        try {
            ServerSocket server_socket = new ServerSocket(666);
            Socket socket = server_socket.accept();
            System.out.println("Message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
