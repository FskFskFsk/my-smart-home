package com.mysmarthome.entities;

public class Light {
    private Integer id;
    private Integer light1;
    private Integer light2;
    private Integer light3;
    private Integer light4;
    public Light(){

    }
    public Light(Integer id,Integer light1,Integer light2,Integer light3,Integer light4){
        this.id=id;
        this.light1=light1;
        this.light2=light2;
        this.light3=light3;
        this.light4=light4;
    }


    public int getLight1() {
        return light1;
    }

    public void setLight1(int light1) {
        this.light1 = light1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLight2() {
        return light2;
    }

    public void setLight2(int light2) {
        this.light2 = light2;
    }

    public int getLight3() {
        return light3;
    }

    public void setLight3(int light3) {
        this.light3 = light3;
    }

    public int getLight4() {
        return light4;
    }

    public void setLight4(int light4) {
        this.light4 = light4;
    }
    public String toString(){
        return "Light [id=" + id +
                " light1=" + light1+
                " light2=" + light2+
                " light3=" + light3+
                " light4=" + light4+


                "]";
    }
}
