package com.example.superheltev4.dto;

public class HeroCityDTO {
    private String heroName;
    private String cityname;

    public HeroCityDTO(String heroName, String cityname){
        this.heroName = heroName;
        this.cityname = cityname;
    }
    public String toString() {
        return "{" + this.heroName + " - " + this.cityname + "}";
    }

    public String getHeroName() {
        return heroName;
    }

    public String getCityname() {
        return cityname;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
