package com.example.superheltev4.repository;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("superhero_stub")
public class SuperheroRepository_stub implements ISuperheltRepository{
    private List<Superhero> superheroes = new ArrayList<Superhero>
            (List.of(
                    new Superhero("Hulk", "Bruce Banner", new Date(1962-01-01)),
                    new Superhero("IronMan", "Tony Stark", new Date(1965-01-01)),
                    new Superhero("SuperMan", "Clark Kent", new Date(1939-01-01))
            ));

    @Override
    public List<Superhero> getSuperheroByName(String name) {
        List<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.equals(name)) {
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
        return null;
    }

    @Override
    public List<HeroPowerCountDTO> getSuperheroesWithNumPowersID(String name) {
        return null;
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
