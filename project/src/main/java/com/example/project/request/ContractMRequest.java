package com.example.project.request;

import java.time.LocalDate;
public class ContractMRequest {

    private LocalDate data;
    private String functie;

    private Long salarBaza;

    private Double comision;

    private Long idAngajat;

    public ContractMRequest( LocalDate data, String functie, Long salarBaza, Double comision, Long id_angajat) {
        this.data = data;
        this.functie = functie;
        this.salarBaza = salarBaza;
        this.comision = comision;
        this.idAngajat = id_angajat;
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

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
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

    public Long getIdAngajat() {
        return idAngajat;
    }
}
