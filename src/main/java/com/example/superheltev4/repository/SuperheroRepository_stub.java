package com.example.superheltev4.repository;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository("superhero_stub")
public class SuperheroRepository_stub implements ISuperheltRepository{
    private List<Superhero> superheroes = new ArrayList<>
            (List.of(
                    new Superhero("Hulk", "Bruce Banner", new Date(1962-01-01)),
                    new Superhero("IronMan", "Tony Stark", new Date(1965-01-01)),
                    new Superhero("SuperMan", "Clark Kent", new Date(1939-01-01))
            ));

    private List<HeroPowerCountDTO> superheroesNum_powers = new ArrayList<>(
            List.of(
                    new HeroPowerCountDTO("Hulk", "Bruce Banner", 2),
                    new HeroPowerCountDTO("IronMan", "Tony Stark", 1),
                    new HeroPowerCountDTO("SuperMan", "Clark Kent", 4)
            )
    );

    @Override
    public List<Superhero> getSuperheroByName(String name) {
        List<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroList.add(superhero);
            }
        }
        return superheroList;
    }

    public List<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    @Override
    public List<HeroPowerCountDTO> getSuperheroesWithNumPowers() {
        return superheroesNum_powers;
    }

    @Override
    public List<HeroPowerCountDTO> getSuperheroesWithNumPowersID(String name) {
        List<HeroPowerCountDTO> superheroList = new ArrayList<>();
        for (HeroPowerCountDTO superhero : superheroesNum_powers) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroList.add(superhero);
            }
        }
        return superheroList;
    }

    @Override
    public List<HeroPowerDTO> getSuperheroesWithPowers() {
        return null;
    }

    @Override
    public List<HeroPowerDTO> getSuperheroesWithPowersID(String navn) {
        return null;
    }

    @Override
    public List<HeroCityDTO> getSuperheroesWithCity() {
        return null;
    }

    @Override
    public List<HeroCityDTO> getSuperheroWithCityID(String input) {
        return null;
    }

}
