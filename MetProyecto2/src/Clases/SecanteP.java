package Clases;

import java.text.DecimalFormat;

//Clase donde se calculan los datos necesarios para el metodo Secante
public class SecanteP {
    private int iterac;
    private double x0;
    private double x1;
    private double f_xn;
    private double f_xn1;
    private double error;
    private static double c1, c2, c3, ind;
    private DecimalFormat decimalFormat;//Limitador de decimales

    public SecanteP(double x0, double x1){
            this.x0 = x0;
            this.x1 = x1;
            this.f_xn = 0;
            this.f_xn1 = 0;
            this.error = 0;
            decimalFormat = new DecimalFormat("###.00000");
        }
    public void actualizarDatos(double x0, double x1){
        this.x0 = x0;
        this.x1 = x1;
    }
    public static void AsignarCoef(double a, double b, double c, double d){
        c1 = a;
        c2 = b;
        c3 = c;
        ind = d;
    }
    //Funcion de x: x^3 +x^2 - 3x - 3
    private double polinomio(double var){
        return Double.parseDouble(decimalFormat.format(c1 * Math.pow(var,3) + c2*Math.pow(var,2) + c3*var + ind));
    }

    public void calcF_xn(){
        f_xn = polinomio(x0);
        f_xn= Double.parseDouble(decimalFormat.format(f_xn));
    }
    public void calcF_xn1(){
        f_xn1 = polinomio(x1);
        f_xn1= Double.parseDouble(decimalFormat.format(f_xn1));
    }
    /*
    El metodo calcularX(), se hizo con el motivo de enviar el valor a la clase que lo llame
    de esta fomra, se podria pasar como parametro del metodo actualizar y de esta manera volviendo a cargar
    x1 con el valor siguiente. Para x0 se llama el metodo getX1, asi se le envia el anterior x1 actualizando  x0.
    */
    public double calcularX(){
        return Double.parseDouble(decimalFormat.format(x1 - ((f_xn1)*((x0 - x1)/(f_xn-f_xn1)))));
    }
    public void calcularError(){
        error = Math.abs(x1-x0)/Math.abs(x1);
        error = Double.parseDouble(decimalFormat.format(error));
    }

    public void setIterac(int iter) {
        this.iterac = iter;
    }
    public void setError(double error) {
        this.error = error;
    }

    public int getIterac() {
        return iterac;
    }
    public double getError() {
        return error;
    }
    public double getX1() {
        return x1;
    }
    public double getF_xn() {
        return f_xn;
    }
    public double getF_xn1() {
        return f_xn1;
    }

    @Override
    public String toString() {
        return "SecanteP{" +
                "iter=" + iterac +
                ", x0=" + x0 +
                ", x1=" + x1 +
                ", f_xn=" + f_xn +
                ", f_xn1=" + f_xn1 +
                ", error=" + error +
                '}';
    }
}
