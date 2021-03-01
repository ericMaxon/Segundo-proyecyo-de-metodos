package Clases;

import java.text.DecimalFormat;
/*Clase para calcular los datos necesarios para el metodo Biseccion*/
public class BiseccionP {
    private int iter;
    private double a;
    private double b;
    private double xr;
    private double f_a;
    private double f_xr;
    private double f_ax;
    private double error;
    private static double c1, c2, c3, ind;
    private DecimalFormat decimalFormat;//Limitador de decimales
        public BiseccionP(double a, double b){
            this.a = a;
            this.b = b;
            decimalFormat = new DecimalFormat("###.00000");
        }

    //Funcion de x: x^3 +x^2 - 3x - 3
    public double polinomio(double var){
        return c1 * Math.pow(var,3) + c2 * Math.pow(var,2) + c3*var + ind;
    }

    public static void AsignarCoef(double a, double b, double c, double d){
            c1 = a;
            c2 = b;
            c3 = c;
            ind = d;
    }

    public static double polinomioV(double var){
        return Math.pow(var,3) + Math.pow(var,2) - 3*var - 3;
    }

    public void calcXr(){xr = Double.parseDouble(decimalFormat.format((a+b)/2));}
    public void calcF_a(){f_a = Double.parseDouble(decimalFormat.format(polinomio(a)));}
    public void calcF_xr(){f_xr = Double.parseDouble(decimalFormat.format(polinomio(xr)));}
    public void calcF_ax(){f_ax = Double.parseDouble(decimalFormat.format(f_xr * f_a));}
    public void calcError(double anterior){
            error = Double.parseDouble(decimalFormat.format(Math.abs(xr - anterior)/Math.abs(xr)));
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    public double getA() {
        return Double.parseDouble(decimalFormat.format(a));
    }
    public double getB() {
        return Double.parseDouble(decimalFormat.format(b));
    }
    public double getF_a() {
        return Double.parseDouble(decimalFormat.format(f_a));
    }
    public double getF_ax() {
        return Double.parseDouble(decimalFormat.format(f_ax));
    }
    public double getF_xr() {
        return Double.parseDouble(decimalFormat.format(f_xr));
    }
    public double getXr() {
        return Double.parseDouble(decimalFormat.format(xr));
    }
    public int getIter() {
        return iter;
    }
    public double getError() {
            return error;
    }

    public static boolean hayCambioEn(double a, double b){
            return ((polinomioV(a) < 0 && polinomioV(b) > 0) || (polinomioV(b) < 0 && polinomioV(a) > 0));
    }
    //Metodos para evaluar el cambio de la funcion f(a) * f(x)
    public boolean vaNegativo(){
            return f_ax<0;
    }
    public boolean vaPositivo(){
        return f_ax>0;
    }

}
