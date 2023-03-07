package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository { //stud metoden
    private List<Superhero> superheroes = new ArrayList<Superhero>
            (List.of());


}
