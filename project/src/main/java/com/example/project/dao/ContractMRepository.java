package com.example.project.dao;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.project.model.Contract_m;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractMRepository extends JpaRepository<Contract_m, Long > {

    /*
    Să se găsească detaliile contractelor de muncă pentru funcțiile ce încep cu litera ‘a’ în
    descrescătoare a salariului de bază și crescătoare după funcție
    */
    @Query("SELECT c FROM Contract_m c WHERE c.functie LIKE :functie% ORDER BY c.salarBaza DESC, c.functie ASC")
    List<Contract_m> findByFunctie(@Param("functie") String functie);

    /*
    Să se găsească contractele de muncă cu același comision ca și alte contracte de muncă.
    */
    @Query("SELECT cm FROM Contract_m cm WHERE cm.comision IN ( SELECT cm2.comision FROM Contract_m cm2 WHERE NOT cm.idAngajat.idP = cm2.idAngajat.idP)")
    List<Contract_m> findPairContracts();

    @Query("SELECT cm FROM Contract_m cm WHERE cm.comision = :comision")
    List<Contract_m> findContractsWithSameComision(@Param("comision") Double comision);
}
