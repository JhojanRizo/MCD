/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Familia-PC
 */
public class ControladorInicio implements ActionListener{
    private VentanaInicio vistaInicio;
    private Modelo modelo;

    public ControladorInicio(VentanaInicio vistaInicio) {
        this.vistaInicio = vistaInicio;
        this.modelo = vistaInicio.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            if (boton == vistaInicio.getBtnMCD()) {
                modelo.calcularMCD();
                modelo.escribirEcuacion("MCD");
            } 
        }
    }  
}
