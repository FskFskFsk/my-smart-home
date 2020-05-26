package com.mysmarthome.entities;

public class Door {
    private Integer id;
    private Integer doorctrl;
    private Integer windowctrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorctrl() {
        return doorctrl;
    }

    public void setDoorctrl(Integer doorctrl) {
        this.doorctrl = doorctrl;
    }

    public Integer getWindowctrl() {
        return windowctrl;
    }

    public void setWindowctrl(Integer windowctrl) {
        this.windowctrl = windowctrl;
    }

    public Door() {

    }

    public Door(Integer id, Integer doorctrl, Integer windowctrl) {
        super();
        this.id = id;
        this.doorctrl = doorctrl;
        this.windowctrl = windowctrl;
    }

    @Override
    public String toString() {
        return "Door{" +
                "Id=" + id +
                ", Doorctrl='" + doorctrl + '\'' +
                ", Windowctrl='" + windowctrl + '\'' +
                '}';
    }
}
