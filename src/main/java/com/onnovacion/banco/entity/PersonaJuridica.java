package com.onnovacion.banco.entity;

import javax.persistence.*;

@Entity
@Table(name = "cli_juridicos")
public class PersonaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenJuridica")
    @SequenceGenerator(name = "mySeqGenJuridica", sequenceName = "cli_sjuridicos", allocationSize = 1)
    @Column(name = "cljrid")
    private int id;

    @Column(name = "cljrrazonsocial")
    private String razonSocial;

    @Column(name = "cljraño", nullable = false)
    private int año;


    @OneToOne(mappedBy = "personaJuridica")
    private PersonaNatural personaNatural;

    public PersonaJuridica() {
    }

    public PersonaJuridica(String razonSocial, int año) {
        this.razonSocial = razonSocial;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
