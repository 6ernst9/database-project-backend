package com.example.project.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.time.LocalDate;

@Table
@Entity
@IdClass(RataId.class)
public class Rata {
    @ManyToOne
    @JoinColumn(name = "id_cj", referencedColumnName = "id_cj", nullable = false, foreignKey = @ForeignKey(name = "id_cj_num_fk"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Id
    private Contract_j id_cj;
    @Id
    @Column(nullable = false, name = "id_r")
    private Long id_r;
    @Column(nullable = false, name = "data")
    private LocalDate data;

    @Column(nullable = false, name = "suma")
    private Long suma;

    public Rata(Contract_j id_cj, Long id_r, LocalDate data, Long suma) {
        this.id_cj = id_cj;
        this.id_r = id_r;
        this.data = data;
        this.suma = suma;
    }

    public Rata() {

    }

    public void setId_cj(Contract_j id_cj) {
        this.id_cj = id_cj;
    }

    public void setId_r(Long id_r) {
        this.id_r = id_r;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setSuma(Long suma) {
        this.suma = suma;
    }

    public Contract_j getId_cj() {
        return id_cj;
    }

    public Long getId_r() {
        return id_r;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getSuma() {
        return suma;
    }
}
