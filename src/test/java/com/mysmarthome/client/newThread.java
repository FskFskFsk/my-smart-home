package com.mysmarthome.client;

import java.io.*;
import java.net.Socket;

public class newThread {

    public static final String IP = "192.168.1.105";//服务器地址
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, 5555);  //ip,port
            //开启多线程接收信息，并解析
            ClientThread thread=new ClientThread(socket);
            thread.start();
            //主线程用来发送信息
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //从控制台输入
            PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
            while(true)
            {
                String s=br.readLine();
                out.println(s);
                out.flush();
            }
        }catch(Exception e){
            System.out.println("服务器异常");
        }
    }

}
