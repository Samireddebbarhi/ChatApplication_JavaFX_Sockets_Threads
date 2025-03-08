package org.example.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main (String[]Args) throws IOException {
        {
            ServerSocket ss = new ServerSocket(9090);
            Socket s = ss.accept();
            System.out.println("Connected to client");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os), true);
            Scanner sc = new Scanner(System.in);
            String msg;
            do {
                msg = bf.readLine();
                System.out.println("Client:" + msg);
                String sendMssg = sc.nextLine();
                pw.println(sendMssg);
            } while (!msg.equals("bye"));


        /* String Received_Msg=bf.readLine();
        pw.println("hello client");
        System.out.println(Received_Msg);
       */
        }
    }



}
