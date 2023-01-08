package com.example.project.request;

import java.time.LocalDate;

public class ContractJRequest {

    private Long id_cj;

    private LocalDate data;
    private String obiect;
    private Long onorar;
    private int nrPagini;
    private Long idClient;
    private Long idAvocat;


    public ContractJRequest(LocalDate data, String obiect, Long onorar, int nrPagini, Long idClient, Long idAvocat) {
        this.data = data;
        this.obiect = obiect;
        this.onorar = onorar;
        this.nrPagini = nrPagini;
        this.idClient = idClient;
        this.idAvocat = idAvocat;
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

    public Long getIdClient() {
        return idClient;
    }

    public Long getIdAvocat() {
        return idAvocat;
    }
}
