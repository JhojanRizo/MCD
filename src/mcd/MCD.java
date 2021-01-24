/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcd;

import MVC.Modelo;

/**
 *
 * @author Familia-PC
 */
public class MCD {

    /**
     * @param args the command line arguments
     */
    public MCD() {
        Modelo modelo = new Modelo();
        modelo.iniciar();
    }

    public static void main(String[] args) {
        new MCD();
    }

}
