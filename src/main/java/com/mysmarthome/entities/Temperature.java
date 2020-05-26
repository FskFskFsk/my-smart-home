package com.mysmarthome.entities;

public class Temperature {
    private Integer id;
    private int[] tem=new int[7];
    public Temperature(){

    }
    public Temperature(int id){
        this.id=id;

        for(int i=0;i<6;i++){
            tem[i]=(int)(Math.random()*40);

        }
        tem[6]=25;


    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int[] getTem(){return tem;}

    public void setTem(int temper) {
        for(int i=0;i<6;i++){
            tem[i]=tem[i+1];
        }
        tem[6]=temper;

    }

    public byte getLastTem(){return (byte)(tem[6]&(0xff));}

    public String toString() {
        return "Temperature [id=" + id + ", Tem =" + tem[0]+" "+
                tem[1]+" "+
                tem[2]+" "+
                tem[3]+" "+
                tem[4]+" "+
                tem[5]+" "+
                tem[6]+" "+
                 "]";
    }

}
