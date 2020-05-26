package com.mysmarthome.entities;

public class Pattern {
    private Integer id;
    private String patternName;
    private int pattern;
    public Pattern(){}
    public Pattern(int i,String patternName){
        this.id=i;
        this.patternName=patternName;
        if("制冷".equals(patternName)){
            this.pattern=-1;

        }else if("送风".equals(patternName)){
            this.pattern=0;
        }else if("制热".equals(patternName)){
            this.pattern=1;
        }

    }
    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public void setPatternName(String patternName){

        this.patternName=patternName;
        if("制冷".equals(patternName)){
            this.pattern=-1;

        }else if("送风".equals(patternName)){
            this.pattern=0;
        }else if("制热".equals(patternName)){
            this.pattern=1;
        }

    }
    public String getPatternName(){return patternName;}
    public byte getpattern(){
        return (byte)(pattern&(0xff));
    }
    public String toString(){

        return "Pattern [id=" + id + ", patternName=" + patternName + "]";
    }


}
