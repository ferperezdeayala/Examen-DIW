package com.example.examendiw;

import java.time.LocalDate;

public class Registro {
    private String matricula;
    private String modelo;
    private LocalDate entrada;
    private LocalDate salida;
    private String cliente;
    private String tarifa;
    private double coste;

    public Registro(String matricula, String modelo, LocalDate entrada, LocalDate salida, String cliente, String tarifa, double coste) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.entrada = entrada;
        this.salida = salida;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.coste = coste;
    }

    // Métodos getters y setters (puedes generarlos automáticamente en tu IDE)

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaEntrada() {
        return entrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.entrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return salida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.salida = fechaSalida;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}

