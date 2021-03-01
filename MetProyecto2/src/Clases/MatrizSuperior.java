package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
/*
* Clase que controla la Matriz Superior*/
public class MatrizSuperior extends AnchorPane {
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
//    Se carga la ventana, con sus datos ya inicializados
        public MatrizSuperior(DoolitleP data){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MatrizSuperior.class.getResource("/UI/MatrizSuperior.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            this.datos = data;
            //datos se utiliza para darle los valores a las celdas
            try{
                fxmlLoader.load();
                celda1.setText(datos.TraerU(0,0)+"");celda2.setText(datos.TraerU(0,1)+"");celda3.setText(datos.TraerU(0,2)+"");
                celda4.setText(datos.TraerU(1,0)+"");celda5.setText(datos.TraerU(1,1)+"");celda6.setText(datos.TraerU(1,2)+"");
                celda7.setText(datos.TraerU(2,0)+"");celda8.setText(datos.TraerU(2,1)+"");celda9.setText(datos.TraerU(2,2)+"");
            }catch (IOException exception){
                throw new RuntimeException(exception);
            }
        }
}
