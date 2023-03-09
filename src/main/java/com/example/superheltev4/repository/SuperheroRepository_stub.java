package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SuperheroRepository_stub {
    private List<Superhero> superheroes = new ArrayList<Superhero>
            (List.of(
                    new Superhero("Hulk", "Bruce Banner", new Date(1962-01-01)
            )));

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }
    public Superhero getSuperheroesID(String id){
        return superheroes.get(Integer.parseInt(id));
    }
    public Superhero addSuperhero(Superhero superhero){
        superheroes.add(superhero);
        return superhero;
    }
}
