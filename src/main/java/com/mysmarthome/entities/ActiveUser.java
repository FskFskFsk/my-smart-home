package com.mysmarthome.entities;

import org.springframework.stereotype.Repository;

@Repository
public class ActiveUser {
    private Integer id;
    public ActiveUser(){

    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "ActiveUser{" +
                "id=" + id +
                '}';
    }
}
