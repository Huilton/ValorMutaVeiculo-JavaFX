/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huilton
 */
public class DadosVeiculoDAO {

    private List<DadosVeiculoVO> arrayVeiculo;

    public DadosVeiculoDAO() {
        arrayVeiculo = new ArrayList<>();

    }

    public List<DadosVeiculoVO> getArrayVeiculo() {
        return arrayVeiculo;
    }

    public void save(DadosVeiculoVO locacao) throws Exception {
        if (!find(locacao)) {
            arrayVeiculo.add(locacao);
        } else {
            throw new Exception("Erro! Veiculo já Casdastrado!!");
        }
    }

    public void remove(int index) throws Exception {
        for (int i = 0; i < arrayVeiculo.size(); i++) {
            if (i == index) {
                arrayVeiculo.remove(i);
                break;
            } else {
                throw new Exception("Erro! Impossível remover este Veiculo!!");
            }
        }
    }

    public double calcularMulta(double velocidadeMaxima, double velocidadeCarro) {
        double resultado = 0;
        double velocidade20 = velocidadeCarro + (velocidadeCarro * 20 / 100);
        double velocidade30 = velocidadeCarro + (velocidadeCarro * 30 / 100);
        double velocidade40 = velocidadeCarro + (velocidadeCarro * 40 / 100);
        double velocidade50 = velocidadeCarro + (velocidadeCarro * 50 / 100);

        if ((velocidadeMaxima < velocidade20) && (velocidadeMaxima < velocidade30) && (velocidadeMaxima < velocidade40) && (velocidadeMaxima < velocidade50)) {
            resultado = 85;
        } else if ((velocidadeMaxima > velocidade20) && (velocidadeMaxima < velocidade30) && (velocidadeMaxima < velocidade40) && (velocidadeMaxima < velocidade50)) {
            resultado = 150;
        } else if ((velocidadeMaxima > velocidade20) && (velocidadeMaxima > velocidade30) && (velocidadeMaxima < velocidade40) && (velocidadeMaxima < velocidade50)) {
            resultado = 250;
        } else if ((velocidadeMaxima > velocidade20) && (velocidadeMaxima > velocidade30) && (velocidadeMaxima > velocidade40) && (velocidadeMaxima < velocidade50)) {
            resultado = 2000;
        }
        return resultado;

    }

    public boolean find(DadosVeiculoVO dadosVeiculo) {
        for (int i = 0; i < arrayVeiculo.size(); i++) {
            if (arrayVeiculo.get(i).getPlaca().equals(dadosVeiculo.getPlaca())
                    && arrayVeiculo.get(i).getData().equals(dadosVeiculo.getPlaca())
                    && arrayVeiculo.get(i).getHora().equals(dadosVeiculo.getPlaca())) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        String str = null;
        for (DadosVeiculoVO e : arrayVeiculo) {
            str += e.toString() + ", \r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0, str.length() - 3);
        }
        return str;
    }

}
