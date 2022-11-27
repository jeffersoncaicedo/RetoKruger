package com.retokruger.RetoKruger.model;

import com.retokruger.RetoKruger.lists.LaboratorioVacuna;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "vacunas")
public class Vacuna {
    @Id
    @SequenceGenerator(name = "vacuneSequence", sequenceName = "id_vacuna_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "vacuneSequence")
    private Long id_vacuna;

    @Schema(required = true)
    @NotNull(message = "Ingrese el nombre del laboratorio, por favor")
    private LaboratorioVacuna laboratorio;

    @Schema(required = true)
    @NotNull(message = "Ingrese la fecha de vacunación, por favor")
    @FutureOrPresent(message = "La fecha ingresada no puede ser mayor a la actual")
    private LocalDate fechavacuna;

    @Schema(required = true)
    @NotNull(message = "Ingrese el número de dosis, por favor")
    private Integer numeroDosis;

    public Vacuna(){

    }

    public Vacuna(LaboratorioVacuna laboratorio, LocalDate fechavacuna, Integer numeroDosis){
        this.laboratorio = laboratorio;
        this.fechavacuna = fechavacuna;
        this.numeroDosis = numeroDosis;
    }

    public Long getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(Long id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public LaboratorioVacuna getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioVacuna laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDate getFechavacuna() {
        return fechavacuna;
    }

    public void setFechavacuna(LocalDate fechavacuna) {
        this.fechavacuna = fechavacuna;
    }

    public Integer getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(Integer numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    @Override
    public String toString(){
        return "Vacuna{" +
                "id=" + id_vacuna +
                ", laboratorio=" + laboratorio +
                ", fecha=" + fechavacuna +
                ", numeroDosis=" + numeroDosis +
                '}';
    }
}
