package com.mysmarthome.server;

import com.mysmarthome.dao.*;
import com.mysmarthome.entities.Door;
import com.mysmarthome.entities.Humidity;
import com.mysmarthome.entities.Temperature;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ThreadServerSocket implements Runnable {

    private Socket server;

    private int BUFFER_SIZE = 1024;

    public ThreadServerSocket() {

    }
    public ThreadServerSocket(Socket i) {
        // TODO Auto-generated constructor stub
        server = i;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            TemperatureDao temperatureDao=new TemperatureDao();
            HumidityDao humidityDao=new HumidityDao();
            AirControlDao airControlDao=new AirControlDao();
            DoorDao doorDao=new DoorDao();
            LightDao lightDao=new LightDao();

            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();
            byte[] b=new byte[BUFFER_SIZE];
            byte[] re=new byte[BUFFER_SIZE];

            while(true) {

                int r = in.read(b);
                System.out.println("User:"+b[0]+"  Temperature："+b[1]+"C   "+
                                "Humidity："+b[2]+"%  ");

                Temperature temm=temperatureDao.get((int)b[0]);
                Humidity humm=humidityDao.get((int)b[0]);

                temperatureDao.change(temm,(int)b[1]);
                humidityDao.change(humm,(int)b[2]);
                re[0]=b[0];
                re[1]=temperatureDao.get((int)b[0]).getLastTem();
                re[2]=humidityDao.get((int)b[0]).getLastHum();
                re[3]=airControlDao.get((int)b[0]).getPattern().getpattern();
                re[4]=airControlDao.get((int)b[0]).getWindspeed().byteValue();
                re[5]=doorDao.get((int)b[0]).getDoorctrl().byteValue();
                re[6]=doorDao.get((int)b[0]).getWindowctrl().byteValue();
                re[7]=(byte)lightDao.get((int)b[0]).getLight1();
                re[8]=(byte)lightDao.get((int)b[0]).getLight2();
                re[9]=(byte)lightDao.get((int)b[0]).getLight3();
                re[10]=(byte)lightDao.get((int)b[0]).getLight4();

               out.write(re);


            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
//            try {
//                //server.close();
//            } catch (IOException e) {
//
//                e.printStackTrace();
//            }
        }

    }


}
