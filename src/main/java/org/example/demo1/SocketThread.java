package org.example.demo1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketThread extends Thread{

    private Socket socket;
    public SocketThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(os),true);
            Scanner sc=new Scanner(System.in);
            String msg;
            pw.println("bienvenue!!");
            do {
                msg= br.readLine();
                System.out.println("client:"+msg);
                System.out.println("Server:");
                msg=sc.nextLine();
                pw.println(msg);
            }while(!msg.equals("bye"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
