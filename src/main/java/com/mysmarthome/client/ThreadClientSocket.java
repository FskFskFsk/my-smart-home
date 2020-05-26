package com.mysmarthome.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

class ThreadClientSocket implements Runnable {

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 1234;

    private Socket client;

    private int activeId;

    public ThreadClientSocket(int activeId) {
        this.activeId=activeId;
        client = new Socket();
        try {
            client.connect(new InetSocketAddress(HOST, PORT), 500);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte id;

        byte temperature;

        byte humidity;

        try {
            OutputStream out = client.getOutputStream();
            InputStream in =client.getInputStream();
            byte []protocol=new byte[1024];   //客户端发往服务器的协议，用protocol数组来模拟显示
            byte []b=new byte[1024];          //客户端接收服务器发来的协议
            int counter = 0;
            while (true) {

                System.out.println("Thread-->"+Thread.currentThread().getName());
                //这里是自动调节，根据随机的温度和湿度，来进行调节
                id=(byte)activeId;

                temperature=(byte) (Math.random()*31);
                humidity=(byte) (Math.random()*100);
                //System.out.println("User:"+id+"  Temperature："+temperature+"C   "+"  Humidity："+humidity+"%  "+"  Pattern："+pattern+"  Wind："+wind+"  "+"  Door："+door+"  Window："+window+"  Light1："+light1+"  Light2："+light2+"  Light3："+light3+"  Light4："+light4);
                //温度与湿度每隔五秒自动传随机数
                System.out.println("User:"+id+"  Temperature："+temperature+"C   "+"  Humidity："+humidity+"%  ");
                protocol[0]=id;
                protocol[1]=temperature;
                protocol[2]=humidity;
                out.write(protocol);



                System.out.println("..............................................");
                int p=in.read(b);
                System.out.println("User： "+b[0]);
                System.out.print("温度："+b[1]+" 湿度:"+b[2]+" 模式:");
                if(b[3]==-1){
                    System.out.print("正在制冷");
                }else if(b[3]==0){
                    System.out.print("正在送风");
                }else{
                    System.out.print("正在制热");
                }
                System.out.print(" 风速:"+b[4]+" 门状态:"+(b[5]==0?'关':'开')+" 窗状态:"+(b[6]==0?'关':'开'));

                System.out.print(" 灯光一:"+(b[7]==0?'关':'开')+" 灯光二:"+(b[8]==0?'关':'开'));
                System.out.println(" 灯光三:"+b[9]+" 灯光四:"+b[10]);

                Thread.sleep(2000);






            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
