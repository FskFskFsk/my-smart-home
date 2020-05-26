package com.mysmarthome.dao;

import com.mysmarthome.entities.Door;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DoorDao {
    private static Map<Integer, Door> doorwindowctrl=null;
    static {
        doorwindowctrl=new HashMap<Integer,Door>();
        doorwindowctrl.put(11,new Door(11,0,0));
        doorwindowctrl.put(12,new Door(12,0,0));
        doorwindowctrl.put(13,new Door(13,0,0));
        doorwindowctrl.put(14,new Door(14,0,0));
        doorwindowctrl.put(15,new Door(15,0,0));
    }
    private static Integer IninIt=16;

    public void Init(){
        doorwindowctrl.put(IninIt,new Door(IninIt++,0,0));
    }
    public Door get(Integer id){

        return  doorwindowctrl.get(id);
    }
    public void change(Door door){
        doorwindowctrl.put(door.getId(),door);
    }
    public void delete(Integer id){
        doorwindowctrl.remove(id);
    }


}
