package com.example.superheltev4.model;

import java.util.Date;

public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private String form;
    private Date yearIntroduced;
    private double strength;

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
        return "{" + this.name + " - " + this.superPower + " - " + this.form + " - " + this.yearIntroduced + " - " + this.strength + "}";
    }

    public String getName() {
        return this.name;
    }
    public String getForm() {
        return this.form;
    }
    public String getSuperPower() {
        return this.superPower;
    }
    public double getStrength() {
        return this.strength;
    }
    public Date getYearIntroduced() {
        return this.yearIntroduced;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSuperPower(String superPower) {
        this.superPower = superPower;
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
    void updateSuperhero(String name, String superPower, String humanForm, Date yearIntroduced, double strength) {
        this.name = name;
        this.superPower = superPower;
        this.form = humanForm;
        this.yearIntroduced = yearIntroduced;
        this.strength = strength;
    }

}
