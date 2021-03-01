package Clases;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;


public class Alerta {


    public static void mostrar(String titulo, String mensaje) {
        Stage ventana = new Stage();
        //Espera a que se cierre la ventana
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinHeight(100);
        ventana.setMinWidth(70);

        //Cuadro de texto
        Label mensajeTx = new Label(mensaje);

        //
        VBox recuadro = new VBox(35);
        recuadro.getChildren().addAll(mensajeTx);
        recuadro.setAlignment(Pos.CENTER);

        Scene mostrando = new Scene(recuadro);
        ventana.setScene(mostrando);
        ventana.showAndWait();
    }
}
