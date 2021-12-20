package com.onnovacion.banco.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cli_naturales")
public class PersonaNatural {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenNatural")
    @SequenceGenerator(name = "mySeqGenNatural", sequenceName = "cli_snaturales", allocationSize = 1)
    @Column(name = "clntid")
    private int id;

    @Column(name = "clntnombre")
    private String nombre;

    @Column(name = "clntapellido")
    private String apellido;

    @Column(name = "clnttipodocumento")
    private String tipoDocumento;

    @Column(name = "clntidentificacion")
    private String identificacion;

    @Column(name = "clntrut")
    private String rut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clntjuridico")
    private PersonaJuridica personaJuridica;

    @OneToMany(mappedBy = "personaNatural")
    Set<Cuenta> cuentas;


    public PersonaNatural() {
    }

    public PersonaNatural(String nombre, String apellido, String tipoDocumento, String identificacion, String rut, PersonaJuridica personaJuridica) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.identificacion = identificacion;
        this.rut = rut;
        this.personaJuridica = personaJuridica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }
}

