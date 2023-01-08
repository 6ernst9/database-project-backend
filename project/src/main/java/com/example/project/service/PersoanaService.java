package com.example.project.service;

import com.example.project.dao.PersoanaRepository;
import com.example.project.model.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class PersoanaService {
    private final PersoanaRepository persoanaRepository;
    @Autowired
    public PersoanaService(PersoanaRepository persoanaRepository) {
        this.persoanaRepository = persoanaRepository;
    }
    public List<Object[]> findPersoaneWithHighestOnorar(){
        return persoanaRepository.findPersoaneWithHighestOnorar();
    }
    public List<Object[]> findPersoaneHiredInYear(int year, String functie){
        LocalDate startDate = Year.of(year).atMonth(1).atDay(1);
        LocalDate endDate = Year.of(year).atMonth(12).atDay(31);
        return persoanaRepository.findPersoaneHiredInAndNotAvocati(startDate, endDate, functie);
    }
    public List<Object[]> findAvgSalaryForYear(int year){
        LocalDate startDate = Year.of(year).atMonth(1).atDay(1);
        LocalDate endDate = Year.of(year).atMonth(12).atDay(31);
        System.out.println(persoanaRepository.findAvgForYear(startDate, endDate).size());
        return persoanaRepository.findAvgForYear(startDate, endDate);
    }
    public Persoana findById(Long id){
        Optional<Persoana> persoana = persoanaRepository.findById(id);
        if(persoana.isPresent()){
            return persoana.get();
        }
        else{
            throw new IllegalStateException("person not found");
        }
    }
    public void addPersoana(Persoana persoana){
        persoanaRepository.save(persoana);
    }
    public List<Persoana> getAllPersoana(){
        return persoanaRepository.findAll();
    }

}
