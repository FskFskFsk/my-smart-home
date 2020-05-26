package com.mysmarthome.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MulThreadSocketServer {


    private static final int PORT = 1234;

    public void Server() {
        System.out.println("服务器已启动......");
        int counter = 1;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(PORT);

            while(true) {
                Socket s = ss.accept();
                System.out.println("第 "+(counter++)+" 个连接");
                Thread t = new Thread(new ThreadServerSocket(s));

                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





/*
                   ServerSocket serverSocket = null;
                   Socket socket = null;
                   InputStream is;
                   OutputStream os;
                   int port = 10000;


                   try {
                       TemperatureDao temperatureDao=new TemperatureDao();

                	
                    serverSocket = new ServerSocket(port);
                    System.out.println("服务器已启动.....");
	                 socket = serverSocket.accept();
	                 byte[] b = new byte[1024];
	                 byte[] re=new byte[1024];
	
	                  os = socket.getOutputStream();
	
	                  is = socket.getInputStream();



	                  while(true){
                          is.read(b);
                          Temperature temm=new Temperature(11);
                          for(int i=0;i<=10;i++){
                              System.out.println(b[i]);
                              re[i]=b[i];
                          }


                          temperatureDao.change(temm,b[1]);
                          Thread.sleep(3000);
                          os.write(re);


                      }
                                     

                   } catch (Exception e) {

                            e.printStackTrace();

                   }finally{
                	   
                   }
 */
    }

}