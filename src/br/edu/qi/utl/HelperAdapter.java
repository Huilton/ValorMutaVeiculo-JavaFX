/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.utl;

import br.edu.qi.model.DadosVeiculoVO;
import br.edu.qi.view.DetranModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huilton
 */
public class HelperAdapter {

    public static List<DetranModel> adater(List<DadosVeiculoVO> arrayDadosVeiculo) {
        List<DetranModel> arrayDetranModel = new ArrayList<>();
        for (DadosVeiculoVO carroVO : arrayDadosVeiculo) {
            DetranModel detranModel = new DetranModel();
            detranModel.setPlaca(carroVO.getPlaca());
            detranModel.setData(carroVO.getData());
            detranModel.setHora(carroVO.getHora());
            detranModel.setLocal(carroVO.getLocal());
            detranModel.setVelocidadePermitidaKm(carroVO.getVelocidadePermitidaKm());
            detranModel.setVelocidadeDoVeiculo(carroVO.getVelocidadeDoVeiculo());
            arrayDetranModel.add(detranModel);
        }
        return arrayDetranModel;
    }
}
