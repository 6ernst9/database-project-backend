package com.example.project.dao;

import com.example.project.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersoanaRepository extends JpaRepository<Persoana, Long> {

    @Query("SELECT p FROM Persoana p WHERE p.idP = :id")
    Optional<Persoana> findById(Long id);
    /*
        Să se găsească numele avocaților care au contract de asistență juridică cu
        onorar maxim.
        */
    @Query("SELECT p, cj.onorar FROM Persoana p JOIN Contract_j cj ON (cj.idAvocat.idP = p.idP) WHERE cj.onorar >= ALL (SELECT cj2.onorar FROM Contract_j cj2)")
    List<Object[]> findPersoaneWithHighestOnorar();

    /*
    Să se găsească numele angajaților cu data de angajare în anul 2022 și care nu sunt
    avocați.
    */
    @Query("SELECT ps, cm.data, cm.functie FROM Contract_m cm JOIN Persoana ps ON (ps.idP = cm.idAngajat.idP) WHERE NOT cm.functie = :functie AND cm.data BETWEEN :startDate AND :endDate")
    List<Object[]> findPersoaneHiredInAndNotAvocati(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate,
                                                    @Param("functie") String functie);
    /*
    Să se găsească pentru fiecare nume de avocat valoarea medie a salariului pe
    anul 2022.
    */
    @Query("SELECT ps , AVG(cm.salarBaza + cm.comision * cj.onorar / 100 / 12) FROM Contract_m cm JOIN Persoana ps ON ( ps.idP = cm.idAngajat.idP ) JOIN Contract_j cj ON (cm.idAngajat.idP = cj.idAvocat.idP) " +
            "WHERE cm.functie = 'avocat' AND (cj.data BETWEEN :startDate AND :endDate) GROUP BY ps.idP, ps.nume, ps.adresa, ps.email, ps.telefon ")
    List<Object[]> findAvgForYear(@Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);
}
