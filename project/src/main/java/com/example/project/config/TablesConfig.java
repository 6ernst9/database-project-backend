package com.example.project.config;

import com.example.project.dao.PersoanaRepository;
import com.example.project.model.Persoana;
import com.example.project.service.ContractJService;
import com.example.project.service.ContractMService;
import com.example.project.service.RataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TablesConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersoanaRepository persoanaRepository, ContractMService contractMService, ContractJService contractJService, RataService rataService){
        return args -> {
            Persoana persoana1 = new Persoana( "John Doe", "jdoe11@gmail.com","Calle del Dr. Fleming, 82, Madrid", 34631005219l);
            Persoana persoana2 = new Persoana( "Samuel Garcia","samu34gar@gmail.com", "Calle de Columela, 35, Madrid", 34629554981l);
            Persoana persoana3 = new Persoana( "Carla Roson","roson1carla@yahoo.com", "Plaza Pablo Ruiz Picasso, 38, Madrid", 34652879916l);
            Persoana persoana4 = new Persoana( "Lucrecia Montesinos", "ludemontesinos@yahoo.com", "Cl. de Ayala, 59, Madrid", 34660994562l);
            Persoana persoana5 = new Persoana( "Patrick Blanco", "patrickblanco@gmail.com", "Calle de Alfonso X, 49 Madrid", 34658651330l);
            Persoana persoana6 = new Persoana( "Christian Varela","itschristian@gmail.com", "Av. de Menéndez Pelayo, 53, Madrid", 34686184012l);
            Persoana persoana7 = new Persoana( "Ander Munoz", "andermunnnoz@yahoo.com","Calle de Sta Engracia, 95, Madrid", 34617266358l);
            Persoana persoana8 = new Persoana( "Rebeka Parilla", "rebbeparilla@outlook.com", "Calle de Pelayo, 52, Madrid", 34623927012l);
            persoanaRepository.saveAll(List.of(persoana1, persoana2,persoana3, persoana4, persoana5, persoana6, persoana7, persoana8));

            contractMService.addContract(LocalDate.of(2018, 10, 24), "avocat", 10000l, 12.0, 1L);
            contractMService.addContract(LocalDate.of(2020, 1, 31), "avocat", 15000l, 12.5, 7L);
            contractMService.addContract(LocalDate.of(2021, 8, 1), "manager", 3000l, 12.0, 8L);
            contractMService.addContract(LocalDate.of(2019, 4, 14), "antrenor", 3000l, 3.0, 5L);
            contractMService.addContract(LocalDate.of(2022, 2, 24), "CEO", 16000l, 7.0, 3L);
            contractMService.addContract(LocalDate.of(2022, 3, 13), "secretara", 6000l, 4.0, 4L);
            contractMService.addContract(LocalDate.of(2022, 7, 31), "ajutator", 2000l, 3.0, 2L);

            contractJService.addContract(LocalDate.of(2022, 10, 15),"actiune civila", 600l , 20 , 8l , 1l);
            contractJService.addContract(LocalDate.of(2022, 10, 2) ,"actiune civila", 1200l , 20 , 5l ,7l);
            contractJService.addContract(LocalDate.of(2022, 10, 22) ,"actiune penala", 200l , 20 , 3l ,7l);
            contractJService.addContract(LocalDate.of(2022, 10, 24) ,"actiune civila", 1200l , 20 , 4l ,1l);
            contractJService.addContract(LocalDate.of(2018, 12, 24) ,"actiune penala", 200l , 40 , 3l ,7l);
            contractJService.addContract(LocalDate.of(2018, 2, 15) ,"actiune penala", 300l , 40 , 4l ,1l);

            rataService.addRata(1l, LocalDate.of(2020, 4, 3), 200l);
            rataService.addRata(1l, LocalDate.of(2020, 6, 3), 200l);
            rataService.addRata(1l,  LocalDate.of(2020, 7, 3), 200l);

            rataService.addRata(2l,  LocalDate.of(2020, 4, 3), 200l);
            rataService.addRata(2l,  LocalDate.of(2020, 6, 3), 200l);

            rataService.addRata(5l,  LocalDate.of(2019, 4, 3), 100l);
            rataService.addRata(5l,  LocalDate.of(2019, 6, 3), 50l);

            rataService.addRata(6l ,LocalDate.of(2019, 5, 14), 100l);
            rataService.addRata(6l,  LocalDate.of(2019, 7, 14), 100l);
        };
    }
}
