package com.example.superheltev4.controller;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.ISuperheltRepository;
import com.example.superheltev4.repository.SuperheroRepository_DB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("superhelte")
public class SuperheroController {

    ISuperheltRepository superheltRepository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        superheltRepository = (ISuperheltRepository) context.getBean(impl);
    }

    @GetMapping("")
    public ResponseEntity<List<Superhero>> getAllSuperheroes() {
        List<Superhero> superheroList = superheltRepository.getAllSuperheroes();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og creationYear

    @GetMapping("/{navn}")
    public ResponseEntity<List<Superhero>> getSuperhero(@PathVariable String navn) {
        List<Superhero> superheroList = superheltRepository.getSuperheroByName(navn);
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og antallet af superkræfter (Superpower)
    @GetMapping("/superpower/count")
    public ResponseEntity<List<HeroPowerCountDTO>> getSuperheroes_num_powers(){
        List<HeroPowerCountDTO> superheroList = superheltRepository.getSuperheroesWithNumPowers();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    //Med navn
    @GetMapping("/superpower/count/{navn}")
    public ResponseEntity<List<HeroPowerCountDTO>> getSuperheroes_num_powers(@PathVariable String navn){
        List<HeroPowerCountDTO> superheroList = superheltRepository.getSuperheroesWithNumPowersID(navn);
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName, superkræfter (Superpower)
    @GetMapping("/superpower")
    public ResponseEntity<List<HeroPowerDTO>> getSuperheroes(){
        List<HeroPowerDTO> superheroList = superheltRepository.getSuperheroesWithPowers();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    // Med navn
    @GetMapping("/superpower/{navn}")
    public ResponseEntity<List<HeroPowerDTO>> getSuperheroesID(@PathVariable String navn){
        List<HeroPowerDTO> superheroList = superheltRepository.getSuperheroesWithPowersID(navn);
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<List<HeroCityDTO>> getSuperheroesWithCity(){
        List<HeroCityDTO> superheroList = superheltRepository.getSuperheroesWithCity();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

    @GetMapping("/city/{navn}")
    public ResponseEntity<List<HeroCityDTO>> getSuperheroesWithCityID(@PathVariable String navn){
        List<HeroCityDTO> superheroList = superheltRepository   .getSuperheroWithCityID(navn);
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }
}
