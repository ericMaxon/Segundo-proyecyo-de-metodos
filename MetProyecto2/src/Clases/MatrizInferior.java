package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
/*Clase que nos mostrara la matriz inferior*/
public class MatrizInferior extends AnchorPane {

    public Label celda1;
    public Label celda2;
    public Label celda3;
    public Label celda4;
    public Label celda5;
    public Label celda6;
    public Label celda7;
    public Label celda8;
    public Label celda9;
    DoolitleP datos;
//Se construye la ventana de Matriz inferior con sus datos
    public MatrizInferior(DoolitleP data){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MatrizInferior.class.getResource("/UI/MatrizInferior.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        this.datos = data;

        try{
            fxmlLoader.load();
            celda1.setText(datos.TraerL(0,0)+"");celda2.setText(datos.TraerL(0,1)+"");celda3.setText(datos.TraerL(0,2)+"");
            celda4.setText(datos.TraerL(1,0)+"");celda5.setText(datos.TraerL(1,1)+"");celda6.setText(datos.TraerL(1,2)+"");
            celda7.setText(datos.TraerL(2,0)+"");celda8.setText(datos.TraerL(2,1)+"");celda9.setText(datos.TraerL(2,2)+"");
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
