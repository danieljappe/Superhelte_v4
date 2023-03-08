package com.example.superheltev4.dto;

import java.util.ArrayList;
import java.util.List;

public class HeroPowerDTO {

    private String name;
    private String realName;
    private List<String> superpowerList;

    public HeroPowerDTO(String name, String realName, List<String> superpowerList){
        this.name = name;
        this.realName = realName;
        this.superpowerList = superpowerList;
    }

    public String toString() {
        return "{" + this.name + " - " + this.realName + " - " + this.superpowerList + "}";
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public List<String> getSuperpowerList() {
        return superpowerList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperpowerList(List<String> superpowerList) {
        this.superpowerList = superpowerList;
    }
}
