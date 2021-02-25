/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia-PC
 */
public class Modelo {

    private Vista vistaMCD;
    private VentanaInicio vistaInicio;
    private Ecuacion ecuacion;
    ArrayList<Integer> numeros = new ArrayList();
    ArrayList<Ecuacion> listaEcuaciones = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    int n;
    int o = 1;
    String respuesta = "";
    String residuos = "";
    String salida = "";
    int n1, n2, nCociente, nResiduo;

    public Vista getVistaMCD() {
        if (vistaMCD == null) {
            this.vistaMCD = new Vista(this);
        }
        return vistaMCD;
    }

    public VentanaInicio getVistaInicio() {
        if (vistaInicio == null) {
            this.vistaInicio = new VentanaInicio(this);
        }
        return vistaInicio;
    }

    public void iniciar() {
        getVistaInicio().setVisible(true);
        vistaInicio.setResizable(false);
    }

    public void calcularMCD() {
        int num, c = 0;
        if (!vistaInicio.getTxtN1().getText().isEmpty()) {
            System.out.println("333");
            numeros.add(Integer.parseInt(vistaInicio.getTxtN1().getText()));
            num = numeros.get(c);
            c++;
//            num = Integer.parseInt(vistaInicio.getTxtN1().getText());
        } 
        if (!vistaInicio.getTxtN2().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN2().getText()));
            num = numeros.get(c);
            c++;
        }
        if (!vistaInicio.getTxtN3().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN3().getText()));
            num = numeros.get(c);
            c++;
        }
        if (!vistaInicio.getTxtN4().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN4().getText()));
            num = numeros.get(c);
            c++;
        }
//        numeros.add(Integer.parseInt(vistaInicio.getTxtN1().getText()));
//        numeros.add(Integer.parseInt(vistaInicio.getTxtN2().getText()));
//        numeros.add(Integer.parseInt(vistaInicio.getTxtN3().getText()));
//        numeros.add(Integer.parseInt(vistaInicio.getTxtN4().getText()));

        System.out.println(numeros);

        if (numeros.size() < 2) {
            System.out.println("........");
            numeros.clear();
            JOptionPane.showMessageDialog(null, "Verifique los numeros ingresados",
                    null, JOptionPane.WARNING_MESSAGE);
        }else{
            Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(numeros, comparador);

        vistaInicio.setVisible(false);
        getVistaMCD().setVisible(true);
        vistaMCD.setResizable(false);

        n1 = numeros.get(0);
        n2 = numeros.get(1);
        nCociente = n1 / n2;
        nResiduo = n1 % n2;

        ecuacion = new Ecuacion();
        ecuacion.setN1(n1);
        ecuacion.setN2(n2);
        ecuacion.setnResiduo(nResiduo);
        ecuacion.setnCociente((-1) * nCociente);
        listaEcuaciones.add(ecuacion);

        respuesta += "\n" + n1 + " = "
                + nCociente + " * " + n2 + " + " + nResiduo + "\n";

        residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                + " * " + n2 + "\n";

        while (nResiduo != 0) {
            n1 = n2;
            n2 = nResiduo;
            nCociente = n1 / n2;
            nResiduo = n1 % n2;

            ecuacion = new Ecuacion();
            ecuacion.setN1(n1);
            ecuacion.setN2(n2);
            ecuacion.setnResiduo(nResiduo);
            ecuacion.setnCociente((-1) * nCociente);
            listaEcuaciones.add(ecuacion);

            respuesta += "\n" + n1 + " = "
                    + nCociente + " * " + n2 + " + " + nResiduo + "\n";

            residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                    + " * " + n2 + "\n";

        }
        if (numeros.size() > 2) {
            for (int i = 2; i < numeros.size(); i++) {
                respuesta += "\n-----Con el siguiente valor-----\n";
                n1 = numeros.get(i);
                nCociente = n1 / n2;
                nResiduo = n1 % n2;
                respuesta += "\n" + n1 + " = "
                        + nCociente + " * " + n2 + " + " + nResiduo + "\n";

                while (nResiduo != 0) {
                    n1 = n2;
                    n2 = nResiduo;
                    nCociente = n1 / n2;
                    nResiduo = n1 % n2;

                    respuesta += "\n" + n1 + " = "
                            + nCociente + " * " + n2 + " + " + nResiduo + "\n";
                }
            }
        }

        salida = "" + numeros.get(0);

        for (int i = 1; i < numeros.size(); i++) {
            salida += "," + numeros.get(i);
        }
        vistaMCD.getLblSalida().setText("MCD(" + salida + ") = " + n2);

        }
        
    }

    public void escribirEcuacion(String opcion) {
        if (opcion == "MCD") {
            getVistaMCD().getTxtMCD().setText(respuesta);
        }
        if (opcion == "Residuos") {
            getVistaMCD().getTxtMCD().setText("\n.....Residuos.....\n" + residuos);
        }
        vistaMCD.getTxtMCD().setEditable(false);
    }

    public void volver() {
        respuesta = "";
        residuos = "";
        listaEcuaciones.clear();
        numeros.clear();
        vistaInicio.setVisible(true);
        vistaInicio.setResizable(false);
        vistaMCD.setVisible(false);
    }
}
