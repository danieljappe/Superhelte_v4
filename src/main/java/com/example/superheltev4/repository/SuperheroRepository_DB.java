package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
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
    public List<Superhero> getAllSuperheroes(){
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","mySqlPassword")){ //Din mySQL database, root som er mySQL username, kodeord til mySQL
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
}
