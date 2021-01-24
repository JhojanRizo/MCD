/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Familia-PC
 */
public class ControladorMCD implements ActionListener {

    private Vista vista;
    private Modelo modelo;

    public ControladorMCD(Vista vista) {
        this.vista = vista;
        this.modelo = vista.getModelo();
        vista.getrBtnMCD().setSelected(true);
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton mcd = vista.getrBtnMCD();
        JRadioButton residuos = vista.getrBtnResiduos();

        grupo.add(mcd);
        grupo.add(residuos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            if (vista.getrBtnMCD().isSelected()) {
                modelo.escribirEcuacion("MCD");
            } else if (vista.getrBtnResiduos().isSelected()) {
                modelo.escribirEcuacion("Residuos");
            }
        }
        if (e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            if (boton == vista.getBtnVolver()) {
                modelo.volver();
            }
        }
    }

}
