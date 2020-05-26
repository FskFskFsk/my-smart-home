package com.mysmarthome.dao;

import com.mysmarthome.entities.Humidity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HumidityDao {

    private static Map<Integer, Humidity> hums=null;

    static {
        hums=new HashMap<Integer, Humidity>();

        hums.put(11,new Humidity(11));
        hums.put(12,new Humidity(12));
        hums.put(13,new Humidity(13));
        hums.put(14,new Humidity(14));
        hums.put(15,new Humidity(15));
    }

    private static Integer initId = 16;

    public void Init(){
        hums.put(initId,new Humidity(initId++));
    }

    public void change(Humidity hum,int humi){
        if(hum.getId()==null){
            hum.setId(initId++);
        }
        hum.setHum(humi);
        hums.put(hum.getId(),hum);


    }

    public Humidity get(Integer id){
        return  hums.get(id);
    }

    public void delete(Integer id){
        hums.remove(id);
    }
}
