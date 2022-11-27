package com.retokruger.RetoKruger.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.retokruger.RetoKruger.lists.EstadoVacunaEmpleado;
import com.retokruger.RetoKruger.lists.LaboratorioVacuna;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table (name="empleados")
public class Empleados {
    @Id
    @SequenceGenerator(name = "employeSecuence", sequenceName = "id_employe_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employeSecuence")
    private Long id_empleado;

    @NotBlank(message = "El campo cédula no puede estar en blanco")
    @NotNull(message = "Ingrese su número de cédula, por favor")
    @Pattern(regexp = "[0-9]{10}", message = "La cédula debe contener 10 números")
    private String cedula;

    @NotBlank(message = "El campo nombres no puede estar en blanco")
    @NotNull(message = "Ingrese sus nombres, por favor")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Los nombres no pueden contener caracteres especiales")
    private String nombres;

    @NotBlank(message = "El campo apellidos no puede estar en blanco")
    @NotNull(message = "Ingrese sus apellidos, por favor")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Los apellidos no pueden contener caracteres especiales")
    private String apellidos;

    @NotBlank(message = "El campo correo no puede estar en blanco")
    @NotNull(message = "Ingrese su dirección de correo, por favor")
    @Email
    private String email;

    @PastOrPresent(message = "La fecha ingresada no puede ser mayor a la actual ")
    private LocalDate fechanacimineto;

    private String direccion;

    @Pattern(regexp = "[0-9]{10}", message = "El número de celular debe contar con 10 dígitos")
    private String telefono;

    @NotNull(message = "El estado de vacunación es requerido")
    private EstadoVacunaEmpleado estado;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_vacuna")
    private Vacuna vacuna;

    public Empleados(){

    }

    public Empleados(Long id_empleado, String cedula, String nombres, String apellidos, String email, EstadoVacunaEmpleado estado){
        this.id_empleado = id_empleado;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.estado = estado;
    }

    public Empleados(Long id_empleado, String cedula, String nombres, String apellidos, String email, LocalDate fechanacimineto, String direccion, String telefono, EstadoVacunaEmpleado estado, LaboratorioVacuna laboratorio, LocalDate fechavacuna, Integer numDosis) {
        this.id_empleado = id_empleado;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.fechanacimineto = fechanacimineto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.vacuna = new Vacuna(laboratorio, fechavacuna, numDosis);
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechanacimineto() {
        return fechanacimineto;
    }

    public void setFechanacimineto(LocalDate fechanacimineto) {
        this.fechanacimineto = fechanacimineto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EstadoVacunaEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoVacunaEmpleado estado) {
        this.estado = estado;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    @Override
    public  String toString(){
        return "Empleado{" +
                "id_empelado=" + id_empleado +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + email + '\'' +
                ", fechaNacimiento=" + fechanacimineto +
                ", direccion='" + direccion + '\'' +
                ", celular='" + telefono + '\'' +
                ", estado=" + estado +
                ", vacuna=" + vacuna +
                '}';
    }
}
