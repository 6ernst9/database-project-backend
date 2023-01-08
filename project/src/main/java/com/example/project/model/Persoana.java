package com.example.project.model;

import jakarta.persistence.*;

@Table
@Entity
public class Persoana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_p")
    private Long idP;
    @Column(nullable = false, name = "nume")
    private String nume;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "adresa")
    private String adresa;

    @Column(nullable = false, name = "telefon")
    private Long telefon;

    public Persoana( String nume, String email, String adresa, Long telefon) {
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Persoana() {

    }

    public Long getId_p() {
        return idP;
    }

    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresa() {
        return adresa;
    }

    public Long getTelefon() {
        return telefon;
    }
}
