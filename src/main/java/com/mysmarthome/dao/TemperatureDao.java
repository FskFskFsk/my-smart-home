package com.mysmarthome.dao;

import com.mysmarthome.entities.Temperature;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TemperatureDao {

    private static Map<Integer, Temperature> tems=null;

    static {
        tems=new HashMap<Integer, Temperature>();
        tems.put(11,new Temperature(11));
        tems.put(12,new Temperature(12));
        tems.put(13,new Temperature(13));
        tems.put(14,new Temperature(14));
        tems.put(15,new Temperature(15));
    }
    private static Integer initId = 16;

    public void Init(){
        tems.put(initId,new Temperature(initId++));
    }

    public void change(Temperature tem,int temper){
        tem.setTem(temper);
        tems.put(tem.getId(),tem);


    }


    public Temperature get(Integer id){

        return  tems.get(id);
    }

    public void delete(Integer id){
        tems.remove(id);
    }



}
