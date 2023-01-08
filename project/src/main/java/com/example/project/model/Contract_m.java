package com.example.project.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
@Table
@Entity
public class Contract_m {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cm;

    @Column(nullable = false, name = "data")
    private LocalDate data;

    @Column(nullable = false, name = "functie")
    private String functie;

    @Column(nullable = false, name = "salar_baza")
    private Long salarBaza;

    @Column(nullable = false, name = "comision")
    private Double comision;

    @ManyToOne
    @JoinColumn(name = "id_angajat", referencedColumnName = "id_p", nullable = false, foreignKey = @ForeignKey(name = "id_angajat_num_fk"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persoana idAngajat;

    public Contract_m(Long id_cm, LocalDate data, String functie, Long salarBaza, Double comision, Persoana id_angajat) {
        this.id_cm = id_cm;
        this.data = data;
        this.functie = functie;
        this.salarBaza = salarBaza;
        this.comision = comision;
        this.idAngajat = id_angajat;
    }
    public Contract_m( LocalDate data, String functie, Long salarBaza, Double comision, Persoana id_angajat) {
        this.data = data;
        this.functie = functie;
        this.salarBaza = salarBaza;
        this.comision = comision;
        this.idAngajat = id_angajat;
    }

    public Contract_m() {

    }

    public void setId_cm(Long id_cm) {
        this.id_cm = id_cm;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public void setSalarBaza(Long salarBaza) {
        this.salarBaza = salarBaza;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public void setIdAngajat(Persoana idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Long getId_cm() {
        return id_cm;
    }

    public LocalDate getData() {
        return data;
    }

    public String getFunctie() {
        return functie;
    }

    public Long getSalarBaza() {
        return salarBaza;
    }

    public Double getComision() {
        return comision;
    }

    public Persoana getIdAngajat() {
        return idAngajat;
    }
}
