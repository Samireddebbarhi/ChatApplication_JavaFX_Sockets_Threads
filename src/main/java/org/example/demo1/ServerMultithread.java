package org.example.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultithread {

    public static void main(String[] args)  {
        try {
            ServerSocket ss = new ServerSocket(9090);

            while (true) {
                Socket s = ss.accept();
                SocketThread socketThread = new SocketThread(s);
                socketThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
