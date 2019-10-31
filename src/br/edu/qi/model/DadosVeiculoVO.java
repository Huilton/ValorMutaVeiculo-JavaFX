/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.Objects;

/**
 *
 * @author Huilton
 */
public class DadosVeiculoVO {

    private String placa;
    private String data;
    private String hora;
    private String local;
    private double velocidadePermitidaKm;
    private double velocidadeDoVeiculo;
    private double valorPagar;

    public DadosVeiculoVO(String placa, String data, String hora, String local, double velocidadePermitidaKm, double velocidadeDoVeiculo, double valorAPagar) {
        this.placa = placa;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.velocidadePermitidaKm = velocidadePermitidaKm;
        this.velocidadeDoVeiculo = velocidadeDoVeiculo;
        this.valorPagar = valorAPagar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.placa);
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.hora);
        hash = 97 * hash + Objects.hashCode(this.local);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.velocidadePermitidaKm) ^ (Double.doubleToLongBits(this.velocidadePermitidaKm) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.velocidadeDoVeiculo) ^ (Double.doubleToLongBits(this.velocidadeDoVeiculo) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valorPagar) ^ (Double.doubleToLongBits(this.valorPagar) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DadosVeiculoVO other = (DadosVeiculoVO) obj;
        if (Double.doubleToLongBits(this.velocidadePermitidaKm) != Double.doubleToLongBits(other.velocidadePermitidaKm)) {
            return false;
        }
        if (Double.doubleToLongBits(this.velocidadeDoVeiculo) != Double.doubleToLongBits(other.velocidadeDoVeiculo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorPagar) != Double.doubleToLongBits(other.valorPagar)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getVelocidadePermitidaKm() {
        return velocidadePermitidaKm;
    }

    public void setVelocidadePermitidaKm(double velocidadePermitidaKm) {
        this.velocidadePermitidaKm = velocidadePermitidaKm;
    }

    public double getVelocidadeDoVeiculo() {
        return velocidadeDoVeiculo;
    }

    public void setVelocidadeDoVeiculo(double velocidadeDoVeiculo) {
        this.velocidadeDoVeiculo = velocidadeDoVeiculo;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

}
