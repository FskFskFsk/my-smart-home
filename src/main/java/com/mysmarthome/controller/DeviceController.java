package com.mysmarthome.controller;

import com.mysmarthome.dao.*;
import com.mysmarthome.entities.*;
import com.sun.media.sound.AiffFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class DeviceController {

    @Autowired
    TemperatureDao temperatureDao;

    @Autowired
    HumidityDao humidityDao;

    @Autowired
    PatternDao patternDao;

    @Autowired
    ActiveUser activeUser;

    @Autowired
    AirControlDao airControlDao;

    @Autowired
    DoorDao doorDao;

    @Autowired
    LightDao lightDao;


    @GetMapping("/tems")
    public String Temperature(Model model){

        Temperature tems=temperatureDao.get(activeUser.getId());
        System.out.println(tems);
        model.addAttribute("tems",tems);

        return "/user/temperature";

    }
    @GetMapping("/hums")
    public String Humidity(Model model){

        Humidity hums=humidityDao.get(activeUser.getId());
        System.out.println(hums);
        model.addAttribute("hums",hums);
        return "/user/humidity";


    }
    @GetMapping("/aircontrol")
    public String AirControl(Model model){


        Temperature tems=temperatureDao.get(activeUser.getId());

        model.addAttribute("tems",tems);

        Humidity hums=humidityDao.get(activeUser.getId());
        model.addAttribute("hums",hums);

        AirControl airs= AirControlDao.get(activeUser.getId());
        model.addAttribute("air",airs);
        //System.out.println(airs);

        Pattern pat=patternDao.getPattern(airs.getPattern().getId());
        model.addAttribute("pat",pat);
        //System.out.println(pat);

        Collection<Pattern> pats=patternDao.getPatterns();
        model.addAttribute("pats",pats);
        //System.out.println(pats);


        //System.out.println(tems+" "+hums);
        return "/user/aircontrol";
    }
    @PostMapping("aircontrol")
    public String AirControl(AirControl airControl){
        airControl.setId(activeUser.getId());

        airControlDao.save(airControl);
        temperatureDao.change(temperatureDao.get(activeUser.getId()),airControl.getTemperature());

        System.out.println(airControl);
        return "redirect:/aircontrol";
    }

    @GetMapping("/light")
    public String Light(Model model){
        Light lights=lightDao.get(activeUser.getId());
        System.out.println(lights);
        model.addAttribute("light",lights);




        return "/user/light";
    }
    @PostMapping("lightcontrol1")
    public String Light(String action){

        System.out.println(action);
        Light lights=lightDao.get(activeUser.getId());
        if(action.equals("openlight1")){
            lights.setLight1(1);
        }else if(action.equals("closelight1")){
            lights.setLight1(0);
        }
        if(action.equals("openlight2")){
            lights.setLight2(1);
        }else if(action.equals("closelight2")){
            lights.setLight2(0);
        }

        return "redirect:/light";
    }
    @PostMapping("lightcontrol2")
    public String Light(Light light){

        light.setId(activeUser.getId());
        System.out.println(light);
        Light lights=lightDao.get(activeUser.getId());
        light.setLight1(lights.getLight1());
        light.setLight2(lights.getLight2());
        lightDao.change(light);


        return "redirect:/light";
    }

    @GetMapping("/door")
    public String Door(Model model){

        Door doors= doorDao.get(activeUser.getId());
        model.addAttribute("door",doors);
        System.out.println(doors);

        return "/user/door";
    }
    @PostMapping("/doorcontrol")
    public String Door(String action){
        Door doors=doorDao.get(activeUser.getId());
        if(action.equals("opendoor")){
            doors.setDoorctrl(1);
        }else if(action.equals("closedoor")){
            doors.setDoorctrl(0);
        }
        if(action.equals("openwindow")){
            doors.setWindowctrl(1);
        }else if(action.equals("closewindow")){
            doors.setWindowctrl(0);
        }


        return "redirect:/door";



    }



}
