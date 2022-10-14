package com.line.domain;

// HospitalParser에서 split한 정보를 id, name, address, ... 으로 정보를 초기화하는 클래스

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergency_room; // 제네릭<T>에 들어가기 때문에 Integer
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String category, String emergency_room,
                    String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.category = category;
        this.emergency_room = Integer.parseInt(emergency_room);
        this.name = name;
        this.subdivision = subdivision;
        setDistrict();
    }
    @Override
    public String toString(){
        return "(\"" + this.id +
                "\", \"" + this.address +
                "\", \"" + this.district +
                "\", \"" + this.category +
                "\", \"" + this.emergency_room +
                "\", \"" + this.name +
                "\", \"" + this.subdivision + "\")";
    }
    public void setDistrict() {
        String[] splitted = address.split(" ");
        district = String.format("%s %s", splitted[0], splitted[1]);
    }
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getDistrict() {
        return district;
    }
    public String getCategory() {
        return category;
    }
    public Integer getEmergency_room() {
        return emergency_room;
    }
    public String getName() {
        return name;
    }
    public String getSubdivision() {
        return subdivision;
    }

}
