package com.example.project.request;

import com.example.project.model.Contract_j;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class RataRequest {
    private Long id_cj;
    private LocalDate data;

    private Long suma;

    public RataRequest(Long id_cj, LocalDate data, Long suma) {
        this.id_cj = id_cj;
        this.data = data;
        this.suma = suma;
    }

    public void setId_cj(Long id_cj) {
        this.id_cj = id_cj;
    }



    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setSuma(Long suma) {
        this.suma = suma;
    }

    public Long getId_cj() {
        return id_cj;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getSuma() {
        return suma;
    }
}
