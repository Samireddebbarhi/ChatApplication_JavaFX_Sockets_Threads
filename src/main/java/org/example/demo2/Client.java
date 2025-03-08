package org.example.demo2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[]Args) throws IOException {
        Socket s=new Socket("localhost",9090);
        System.out.println("Connected to server");
        InputStream is=s.getInputStream();
        OutputStream os= s.getOutputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(os),true);
        Scanner sc=new Scanner(System.in);
        String msg;
        do {
            String sendMess= sc.nextLine();
            pw.println(sendMess);
            msg= br.readLine();
            System.out.println("server:"+msg);
        }while(!msg.equals("bye"));

       /*pw.println("Hello Server !!");
    String ReceivedMsg=br.readLine();
       System.out.println(ReceivedMsg);
      */

    }
}
