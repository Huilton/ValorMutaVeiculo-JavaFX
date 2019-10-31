/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author Huilton
 */
public class DadosVeiculo {

    public static DadosVeiculo instance;

    private static DadosVeiculoDAO dao;

    public DadosVeiculo() {

    }

    public DadosVeiculoDAO getDao() {
        return dao;
    }

    public static DadosVeiculo getInstance() {
        if (instance == null) {
            instance = new DadosVeiculo();
            dao = new DadosVeiculoDAO();

        }
        return instance;
    }

    public void remove(int index) throws Exception {
        dao.remove(index);
    }

    public void save(DadosVeiculoVO locacao) throws Exception {

        dao.save(locacao);

    }

}
