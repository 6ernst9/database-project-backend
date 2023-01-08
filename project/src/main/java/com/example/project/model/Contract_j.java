package com.example.project.model;

import jakarta.persistence.*;
import lombok.NonNull;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table
public class Contract_j {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cj;


    @Column(nullable = false, name = "data")
    private LocalDate data;
    @Column(nullable = false, name = "obiect")
    @Check(constraints = "obiect IN('actiune civila', 'actiune penala') AND ((obiect = 'actiune civila' AND onorar > 500) OR (obiect != 'actiune civila' AND onorar <= 500))")
    private String obiect;

    @Column(nullable = false, name = "onorar")
    private Long onorar;

    @Column(nullable = false, name = "nr_pagini")
    private int nrPagini;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_p", nullable = false, foreignKey = @ForeignKey(name = "id_client_num_fk"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persoana idClient;

    @ManyToOne
    @JoinColumn(name = "id_avocat", referencedColumnName = "id_p", nullable = false, foreignKey = @ForeignKey(name = "id_avocat_num_fk"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persoana idAvocat;

    public Contract_j(Long id_cj, LocalDate data, String obiect, Long onorar, int nrPagini, Persoana idClient, Persoana idAvocat) {
        this.id_cj = id_cj;
        this.data = data;
        this.obiect = obiect;
        this.onorar = onorar;
        this.nrPagini = nrPagini;
        this.idClient = idClient;
        this.idAvocat = idAvocat;
    }
    public Contract_j(LocalDate data, String obiect, Long onorar, int nrPagini, Persoana idClient, Persoana idAvocat) {
        this.data = data;
        this.obiect = obiect;
        this.onorar = onorar;
        this.nrPagini = nrPagini;
        this.idClient = idClient;
        this.idAvocat = idAvocat;
    }

    public Contract_j() {

    }

    public Long getId_cj() {
        return id_cj;
    }

    public LocalDate getData() {
        return data;
    }

    public String getObiect() {
        return obiect;
    }

    public Long getOnorar() {
        return onorar;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public Persoana getIdClient() {
        return idClient;
    }

    public Persoana getIdAvocat() {
        return idAvocat;
    }
}
