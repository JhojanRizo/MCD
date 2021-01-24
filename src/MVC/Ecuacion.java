/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author Familia-PC
 */
public class Ecuacion {

    int n1, n2, nResiduo, nCociente;

    Ecuacion() {
        
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getnResiduo() {
        return nResiduo;
    }

    public void setnResiduo(int nResiduo) {
        this.nResiduo = nResiduo;
    }

    public int getnCociente() {
        return nCociente;
    }

    public void setnCociente(int nCociente) {
        this.nCociente = nCociente;
    }
    
    

    public void agregarDatos(int N1, int N2, int nRes, int n, int nCoc) {
        n1 = N1;
        n2 = N2;
        nResiduo = nRes;
        nCociente = nCoc;
    }
}
