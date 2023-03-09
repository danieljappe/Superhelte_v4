package com.example.superheltev4.repository;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;

import java.util.List;

public interface ISuperheltRepository {

    //1. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og creationYear
    List<Superhero> getSuperheroByName(String name);
    List<Superhero> getAllSuperheroes();

    //2. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og antallet af superkræfter (Superpower)
    List<HeroPowerCountDTO> getSuperheroesWithNumPowers();
    List<HeroPowerCountDTO> getSuperheroesWithNumPowersID(String name);

    //3. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName, superkræfter (Superpower)
    List<HeroPowerDTO> getSuperheroesWithPowers();
    List<HeroPowerDTO> getSuperheroesWithPowersID(String navn);

    //4. En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName og by (City
    List<HeroCityDTO> getSuperheroesWithCity();
    List<HeroCityDTO> getSuperheroWithCityID(String input);
}
