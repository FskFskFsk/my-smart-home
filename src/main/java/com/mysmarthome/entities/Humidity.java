package com.mysmarthome.entities;

public class Humidity {
    private Integer id;
    private int[] hum=new int[7];
    public Humidity(){

    }
    public Humidity(int id){
        this.id=id;

        for(int i=0;i<6;i++){
            hum[i]=(int)(Math.random()*100);
        }
        hum[6]=50;


    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int[] getHum(){return hum;}

    public void setHum(int humi) {
        for(int i=0;i<6;i++){
            hum[i]=hum[i+1];
        }
        hum[6]=humi;

    }
    public byte getLastHum(){return (byte)(hum[6]&(0xff));}

    public String toString() {
        return "Humidity [id=" + id + ", Hum =" + hum[0]+" "+
                hum[1]+" "+
                hum[2]+" "+
                hum[3]+" "+
                hum[4]+" "+
                hum[5]+" "+
                hum[6]+" "+
                "]";
    }
}
