package com.onnovacion.banco.entity;

import javax.persistence.*;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenMovimiento")
    @SequenceGenerator(name = "mySeqGenMovimiento", sequenceName = "smovimientos", allocationSize = 1)
    @Column(name = "movid")
    private int id;

    @Column(name = "movdatestamp")
    private String dateStamp;

    @Column(name = "movvalor")
    private long valor;

    @ManyToOne
    @JoinColumn(name = "movcuenta")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(String dateStamp, long valor, Cuenta cuenta) {
        this.dateStamp = dateStamp;
        this.valor = valor;
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
