package com.mysmarthome.dao;

import com.mysmarthome.entities.ActiveUser;
import com.mysmarthome.entities.AirControl;
import com.mysmarthome.entities.Pattern;
import com.mysmarthome.entities.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AirControlDao {
    private static Map<Integer, AirControl> airControls=null;

    @Autowired
    private PatternDao patternDao;

    @Autowired
    private TemperatureDao temperatureDao;


    @Autowired
    private ActiveUser activeUser;

    static{
        airControls=new HashMap<Integer, AirControl>();

        airControls.put(11,new AirControl(1001,new Pattern(101,"制冷"),25,30));
        airControls.put(12,new AirControl(1002,new Pattern(101,"制冷"),25,30));
        airControls.put(13,new AirControl(1003,new Pattern(101,"制冷"),25,30));
        airControls.put(14,new AirControl(1004,new Pattern(101,"制冷"),25,30));
        airControls.put(15,new AirControl(1005,new Pattern(101,"制冷"),25,30));

    }
    private static Integer IninIt=16;
    public void Init(){
        airControls.put(IninIt,new AirControl(IninIt++,new Pattern(101,"制冷"),25,30));

    }

    public void save(AirControl airControl){
        if(airControl.getId()==null){
            airControl.setId(IninIt++);
        }
        airControl.setPattern(patternDao.getPattern(airControl.getPattern().getId()));

        airControls.put(airControl.getId(),airControl);
    }

    public static AirControl get(Integer id){return airControls.get(id);}


    public void delete(Integer id){
        airControls.remove(id);
    }






}
