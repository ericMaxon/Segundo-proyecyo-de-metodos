package Clases;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/*Clase que controla los procesos u acciones realizadas dentro de la ventana
* */
public class InsercionIntervalos extends AnchorPane {
    public double a, b,c1,c2,c3,ind;
    public TextField inicio;
    public TextField fin;
    public TextField C1;
    public TextField C2;
    public TextField C3;
    public TextField Ind;
// Creaacion de la ventana
    InsercionIntervalos(){
            FXMLLoader loader = new FXMLLoader();
            loader.setRoot(this);
            loader.setController(this);
            loader.setLocation(InsercionIntervalos.class.getResource("/UI/InsercionIntervalos.fxml"));
            try{
                inicio = new TextField();
                fin = new TextField();
                C1 = new TextField();
                C2 = new TextField();
                C3 = new TextField();
                Ind = new TextField();
                loader.load();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

/*Se realiza la obtencion de los datos ingresados por el usuario
* Este metodo controla que todos los datos que hayan sido ingresados sean correctos*/
    public void enviarData(ActionEvent actionEvent) {
            double auxA, auxB, auxC1,auxC2, auxC3,auxInd;
            Convertir real = new Convertir();
            auxA = real.DatosD(inicio.getText());
            auxB = real.DatosD(fin.getText());
            auxC1 = real.DatosD(C1.getText());
            auxC2 = real.DatosD(C2.getText());
            auxC3 = real.DatosD(C3.getText());
            auxInd = real.DatosD(Ind.getText());
            a = auxA; b = auxB; c1 = auxC1; c2 = auxC2; c3 = auxC3; ind = auxInd;

            BiseccionP.AsignarCoef(c1,c2,c3,ind);
//            El metodo esError(), le avisa al usuario que no ha ingresado los datos correctamete
             if (real.esError()) {
                 //El metodo hayCambioEn(), verfica que exista un cambio de signo en el intevalo dado.
                 if (!BiseccionP.hayCambioEn(a,b))
                     Alerta.mostrar("No hay cambio en la funcion","Intente con un nuevo intervalo, para usar el metodo Biseccion");
                 else
                     Alerta.mostrar("Enviado", "Se han enviado correctamente los datos");
             }
             C1.setPromptText(c1+"");C2.setPromptText(c2+"");C3.setPromptText(c3+"");Ind.setPromptText(ind+"");
             inicio.setPromptText(a+"");fin.setPromptText(b+"");
    }
}
