package com.example.superheltev4.repository;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class SuperheroRepository_DB {
    /* metode fungerer ikke, kan ikke lokalisere i drivermanager.
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;
*/

    // En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og creationYear
    public List<Superhero> getAllSuperheroes(){
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")){ //Din mySQL database, root som er mySQL username, kodeord til mySQL
            String SQL = "SELECT * FROM SUPERHERO;"; // SQL select all statement
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                superheroes.add(new Superhero(rs.getString("SUPERHERONAME"),rs.getString("REALNAME"),rs.getDate("CREATIONYEAR")));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName og antallet af superkræfter (Superpower)
    public List<HeroPowerCountDTO> getSuperheroesWithNumPowers() {
        List<HeroPowerCountDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")) {
            String SQL = "SELECT superhero.superheroname, superhero.realname, COUNT(superhero_power.powerid) AS num_powers " +
                    "FROM superhero LEFT JOIN superhero_power ON superhero.superheroname = superhero_power.superheroname " +
                    "GROUP BY superhero.superheroname, superhero.realname";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                superheroes.add(new HeroPowerCountDTO(rs.getString("superheroname"), rs.getString("realname"), rs.getInt("num_powers")));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<HeroPowerCountDTO> getSuperheroesWithNumPowersID(String name) {
        List<HeroPowerCountDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")) {
            String SQL = "SELECT superhero.superheroname, superhero.realname, COUNT(superhero_power.powerid) AS num_powers " +
                    "FROM superhero LEFT JOIN superhero_power ON superhero.superheroname = superhero_power.superheroname " +
                    "where superhero.superheroname = ?" +
                    "GROUP BY superhero.superheroname, superhero.realname";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                superheroes.add(new HeroPowerCountDTO(rs.getString("superheroname"), rs.getString("realname"), rs.getInt("num_powers")));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder:
    //heroName, realName, superkræfter (Superpower)
    public List<HeroPowerDTO> getSuperheroesWithPowers() {
        List<HeroPowerDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")) {
            String SQL = "SELECT s.superheroname, s.realname, GROUP_CONCAT(sp.powername) AS superpowers\n" +
                    "FROM superhero s\n" +
                    "LEFT JOIN superhero_power shp ON s.superheroname = shp.superheroname\n" +
                    "LEFT JOIN superpower sp ON shp.powerID = sp.superpowerID\n" +
                    "GROUP BY s.superheroname, s.realname;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String name = rs.getString("superheroname");
                String realName = rs.getString("realname");
                List<String> superpowerList = Arrays.asList(rs.getString("superpowers").split(","));
                superheroes.add(new HeroPowerDTO(name, realName, superpowerList));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HeroPowerDTO> getSuperheroesWithPowersID(String navn) {
        List<HeroPowerDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")) {
            String SQL = "SELECT s.superheroname, s.realname, GROUP_CONCAT(sp.powername) AS superpowers\n" +
                    "FROM superhero s\n" +
                    "LEFT JOIN superhero_power shp ON s.superheroname = shp.superheroname\n" +
                    "LEFT JOIN superpower sp ON shp.powerID = sp.superpowerID\n" +
                    "WHERE s.superheroname = ? " +
                    "GROUP BY s.superheroname, s.realname;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,navn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("superheroname");
                String realName = rs.getString("realname");
                List<String> superpowerList = Arrays.asList(rs.getString("superpowers").split(","));
                superheroes.add(new HeroPowerDTO(name, realName, superpowerList));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder: heroName og by (City)
    public List<HeroCityDTO> getSuperheroesWithCity() {
        List<HeroCityDTO> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","Qhr96wmr2k")) {
            String SQL = "select s.superheroname, c.cityname\n" +
                    "from superhero s\n" +
                    "left join city c on s.cityid = c.cityid\n" +
                    "group by s.superheroname;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                superheroes.add(new HeroCityDTO(rs.getString("s.superheroname"), rs.getString("c.cityname")));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Superhero> getSuperhero(String name) {
        ArrayList<Superhero> allSuperheroes = (ArrayList<Superhero>) this.getAllSuperheroes();
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for (Superhero superhero: allSuperheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }
}
