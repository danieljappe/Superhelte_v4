package com.example.superheltev4.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private String form;
    private Date yearIntroduced;
    private double strength;
    private int num_powers;
    private List<String> superpowerList = new ArrayList<String>();

    public Superhero(String name, String realName, String superPower, String humanForm, Date yearIntroduced, double strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.form = humanForm;
        this.yearIntroduced = yearIntroduced;
        this.strength = strength;
    }

    public Superhero(String name, String realName, Date yearIntroduced) {
        this.name = name;
        this.realName = realName;
        this.yearIntroduced = yearIntroduced;
    }

    public String toString() {
        return "{" + this.name + " - " + this.realName + " - " + this.yearIntroduced + "}";
    }

    public String getName() {
        return this.name;
    }
    public String getRealName() {
        return realName;
    }
    public String getForm() {
        return this.form;
    }
    public String getSuperPower() {
        return this.superPower;
    }

    public List<String> getSuperpowerList() {
        return superpowerList;
    }

    public double getStrength() {
        return this.strength;
    }
    public Date getYearIntroduced() {
        return this.yearIntroduced;
    }
    public int getNum_powers() {
        return num_powers;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setSuperpowerList(List<String> superpowerList) {
        this.superpowerList = superpowerList;
    }

    public void setForm(String form) {
        this.form = form;
    }
    public void setYearIntroduced(Date yearIntroduced) {
        this.yearIntroduced = yearIntroduced;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setNum_powers(int num_powers) {
        this.num_powers = num_powers;
    }

    void updateSuperhero(String name, String superPower, String humanForm, Date yearIntroduced, double strength) {
        this.name = name;
        this.superPower = superPower;
        this.form = humanForm;
        this.yearIntroduced = yearIntroduced;
        this.strength = strength;
    }

}
