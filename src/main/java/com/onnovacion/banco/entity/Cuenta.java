package com.onnovacion.banco.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenCuenta")
    @SequenceGenerator(name = "mySeqGenCuenta", sequenceName = "scuentas", allocationSize = 1)
    @Column(name = "ctaid")
    private int id;

    @Column(name = "ctanumero")
    private int numero;
    @Column(name = "ctamoneda")
    private String moneda;
    @Column(name = "ctasaldo")
    private long saldo;

    @ManyToOne
    @JoinColumn(name = "ctacliente")
    private PersonaNatural personaNatural;

    @OneToMany(mappedBy = "cuenta")
    Set<Movimiento> movimientos;

    public Cuenta() {
    }

    public Cuenta(int numero, String moneda, long saldo, PersonaNatural personaNatural) {
        this.numero = numero;
        this.moneda = moneda;
        this.saldo = saldo;
        this.personaNatural = personaNatural;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public PersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(PersonaNatural personaNatural) {
        this.personaNatural = personaNatural;
    }
}
