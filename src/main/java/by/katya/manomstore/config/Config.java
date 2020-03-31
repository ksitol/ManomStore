package by.katya.manomstore.config;


import by.katya.manomstore.entity.Manometer;
import by.katya.manomstore.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan ("by.katya.manomstore")
public class Config {

    @Bean
    public List<Manometer> manometers () {
        return  new ArrayList<>();
    }

    @Bean
    public User currentUser () {
        return new User ();
    }


}
