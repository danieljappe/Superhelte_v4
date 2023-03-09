package com.example.superheltev4.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Superhero {
    private String name;
    private String realName;
    private java.sql.Date yearIntroduced;


    public Superhero(String name, String realName, java.sql.Date yearIntroduced) {
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

    public Date getYearIntroduced() {
        return this.yearIntroduced;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setYearIntroduced(java.sql.Date yearIntroduced) {
        this.yearIntroduced = yearIntroduced;
    }

}
