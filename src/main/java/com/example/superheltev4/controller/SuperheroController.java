package com.example.superheltev4.controller;

import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.SuperheroRepository_DB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("superhelte")
public class SuperheroController {
    SuperheroRepository_DB superheroRepository_DB = new SuperheroRepository_DB();

    @GetMapping("/all")
    public ResponseEntity<List<Superhero>> getAllSuperheroes() {
        List<Superhero> superheroList = superheroRepository_DB.getAllSuperheroes();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }
}
