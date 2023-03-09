package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhero;

import java.util.List;

public interface ISuperheltRepository {
    List<Superhero> getAll();

    void addSuperhelt(Superhero superhero);
}
