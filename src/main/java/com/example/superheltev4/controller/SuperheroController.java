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
import org.springframework.ui.Model;
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


    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og creationYear
    @GetMapping("")
    String getPeople(Model model){
        List<Superhero> superheroList = superheltRepository.getAllSuperheroes();
        model.addAttribute("people", superheroList);
        return "superheroHTML";
    }

    @GetMapping("/{navn}")
    public String getSuperhero(Model model,@PathVariable String navn) {
        List<Superhero> superheroList = superheltRepository.getSuperheroByName(navn);
        model.addAttribute("people", superheroList);
        return "superheroHTML";
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og antallet af superkræfter (Superpower)
    @GetMapping("/superpower/count")
    public String getSuperheroes_num_powers(Model model){
        List<HeroPowerCountDTO> superheroList = superheltRepository.getSuperheroesWithNumPowers();
        model.addAttribute("peoplecount", superheroList);
        return "superheroCountHTML";
    }


    //Med navn
    @GetMapping("/superpower/count/{navn}")
    public String getSuperheroes_num_powers(Model model,@PathVariable String navn){
        List<HeroPowerCountDTO> superheroList = superheltRepository.getSuperheroesWithNumPowersID(navn);
        model.addAttribute("peoplecount", superheroList);
        return "superheroCountHTML";
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName, superkræfter (Superpower)
    @GetMapping("/superpower")
    public String getSuperheroes(Model model){
        List<HeroPowerDTO> superheroList = superheltRepository.getSuperheroesWithPowers();
        model.addAttribute("peoplepower", superheroList);
        return "superheroPowerHTML";
    }

    // Med navn
    @GetMapping("/superpower/{navn}")
    public String getSuperheroesID(Model model,@PathVariable String navn){
        List<HeroPowerDTO> superheroList = superheltRepository.getSuperheroesWithPowersID(navn);
        model.addAttribute("peoplepower", superheroList);
        return "superheroPowerHTML";
    }

    @GetMapping("/city")
    public String getSuperheroesWithCity(Model model){
        List<HeroCityDTO> superheroList = superheltRepository.getSuperheroesWithCity();
        model.addAttribute("peoplecity", superheroList);
        return "superheroCityHTML";
    }

    @GetMapping("/city/{navn}")
    public String getSuperheroesWithCityID(Model model, @PathVariable String navn){
        List<HeroCityDTO> superheroList = superheltRepository   .getSuperheroWithCityID(navn);
        model.addAttribute("peoplecity", superheroList);
        return "superheroCityHTML";
    }
}
