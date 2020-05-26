package com.mysmarthome.entities;

public class AirControl {
    private Integer id;
    private Pattern pattern;
    private Integer temperature;
    private Integer windspeed;
    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){return id;}

    public void setPattern(Pattern pattern){this.pattern=pattern;}
    public Pattern getPattern(){return pattern;}

    public void setTemperature(Integer temperature){this.temperature=temperature;}
    public Integer getTemperature(){return temperature;}
    public void setWindspeed(Integer windspeed){this.windspeed=windspeed;}
    public Integer getWindspeed(){return windspeed;}
    public AirControl(){

    }
    public AirControl(Integer id,Pattern pattern,Integer temperature,Integer windspeed){
        super();
        this.id=id;
        this.pattern=pattern;
        this.temperature=temperature;
        this.windspeed=windspeed;


    }
    public String toString(){
        return "AirControl{" +
                "Id=" + id +
                ", Pattern='" + pattern + '\'' +
                ", Temperature='" + temperature + '\'' +
                ", WindSpeed='" + windspeed + '\'' +
                '}';
    }

}
