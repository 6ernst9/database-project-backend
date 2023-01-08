package com.example.project.dao;

import com.example.project.model.Contract_j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContractJRepository extends JpaRepository< Contract_j, Long> {

    @Query("SELECT c FROM Contract_j c WHERE c.id_cj = :id")
    Optional<Contract_j> findById(Long id);

    /*
    Să se găsească detaliile pentru contractele de asistență juridică din luna octombrie 2022
    ce au onorar cuprins între 900 și 1500 în ordine crescătoare a datei
    */
    @Query("SELECT c FROM Contract_j c WHERE c.data BETWEEN :startDate AND :endDate AND c.onorar BETWEEN :minOnorar " +
            "AND :maxOnorar ORDER BY c.data ASC")
    List<Contract_j> findByDateRangeAndOnorarRange(@Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate,
                                                  @Param("minOnorar") int minOnorar,
                                                  @Param("maxOnorar") int maxOnorar);
    /*
    Să se găsească contractele juridice care nu au fost achitate în întregime
    */
    @Query("SELECT cj FROM Contract_j cj WHERE cj.onorar > ( SELECT SUM(rt.suma)  FROM Rata rt WHERE rt.id_cj.id_cj = cj.id_cj) OR cj.id_cj NOT IN (SELECT rt2.id_cj.id_cj FROM Rata rt2)")
    Optional<List<Contract_j>> findByNotPaid();

    /*
    Să se găsească perechi de contracte juridice (id_cj1, id_cj2) pentru clienți diferiți dar
    același avocat. O pereche este unică în rezultat
     */
    @Query("SELECT cj1 , cj2 FROM Contract_j cj1 JOIN Contract_j cj2 ON (cj1.idAvocat.idP = cj2.idAvocat.idP) " +
            "WHERE NOT cj1.idClient.idP = cj2.idClient.idP AND cj1.id_cj < cj2.id_cj")
    List<Object[]> findPairContractsByAvocatId();

}
