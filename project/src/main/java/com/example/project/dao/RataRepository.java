package com.example.project.dao;

import com.example.project.model.Rata;
import com.example.project.model.RataId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RataRepository extends JpaRepository<Rata, RataId> {
    @Query("SELECT MAX(r.id_r) FROM Rata r WHERE r.id_cj.id_cj = :id")
    Optional<Long> getLastById(Long id);
}
