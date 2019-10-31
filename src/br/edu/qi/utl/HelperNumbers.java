/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.utl;

/**
 *
 * @author Huilton
 */
public class HelperNumbers {

    public static boolean isNumeric(String s) throws Exception {
        try {
            float num = Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
