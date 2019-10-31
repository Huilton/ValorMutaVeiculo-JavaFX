/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Huilton
 */
public class DetranModel {

    private SimpleStringProperty placa = new SimpleStringProperty();
    private SimpleStringProperty data = new SimpleStringProperty();
    private SimpleStringProperty hora = new SimpleStringProperty();
    private SimpleStringProperty local = new SimpleStringProperty();
    private SimpleDoubleProperty velocidadePermitidaKm = new SimpleDoubleProperty();
    private SimpleDoubleProperty velocidadeDoVeiculo = new SimpleDoubleProperty();
    private SimpleDoubleProperty valorApagar = new SimpleDoubleProperty();

    public String getPlaca() {
        return placa.get();
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public String getLocal() {
        return local.get();
    }

    public void setLocal(String local) {
        this.local.set(local);
    }

    public double getVelocidadeMaximaPermitidaKm() {
        return velocidadePermitidaKm.get();
    }

    public void setVelocidadePermitidaKm(double VelocidadePermitidaKm) {
        this.velocidadePermitidaKm.set(VelocidadePermitidaKm);
    }

    public double getVelocidadeDoVeiculo() {
        return velocidadeDoVeiculo.get();
    }

    public void setVelocidadeDoVeiculo(double velocidadeMaximaPermitida) {
        this.velocidadePermitidaKm.set(velocidadeMaximaPermitida);
    }

    public double getValorAPagar() {
        return valorApagar.get();
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorApagar.set(valorAPagar);
    }

}
