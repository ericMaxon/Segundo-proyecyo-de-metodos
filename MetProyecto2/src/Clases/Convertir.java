package Clases;
/*
    Convierte a double los cadenas.
*/

public class Convertir {
    private double inputD;
    private boolean error;

    //Conversion a Datos double
    public double DatosD(String leer) {
            try {
                inputD = Double.parseDouble(leer);
                error = true;
            } catch (NumberFormatException er) {
                Alerta.mostrar("Conversion erronea de datos","Ingrese todos los datos");
                error = false;
            }
        return inputD;
    }
    //Metodo para controlar que se hayan ingresado correctamente los datos
    public boolean esError() {
        return error;
    }
}
