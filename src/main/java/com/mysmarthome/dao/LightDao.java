package com.mysmarthome.dao;

import com.mysmarthome.entities.Light;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LightDao {
    private static Map<Integer, Light> lights=null;
    static{

        lights=new HashMap<Integer, Light>();

        lights.put(11,new Light(11,0,0,25,25));
        lights.put(12,new Light(12,0,0,25,25));
        lights.put(13,new Light(13,0,0,25,25));
        lights.put(14,new Light(14,0,0,25,25));
        lights.put(15,new Light(15,0,0,25,25));



    }
    private static Integer Initid=16;

    public void Init(){
        lights.put(Initid,new Light(Initid++,0,0,25,25));
    }
    public void change(Light light){
        lights.put(light.getId(),light);

    }
    public Light get(Integer id){
        return lights.get(id);
    }
    public void delete(Integer id){
        lights.remove(id);
    }


}
