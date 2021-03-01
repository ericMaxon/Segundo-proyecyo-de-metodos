package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
/*Clase que controla la ventana resultado*/
public class Resultado extends AnchorPane {
    DoolitleP datos;
    public Label L11;public Label L12;public Label L13;
    public Label L21;public Label L22;public Label L23;
    public Label L31;public Label L32;public Label L33;

    public Label U11;public Label U12;public Label U13;
    public Label U21;public Label U22;public Label U23;
    public Label U31;public Label U32;public Label U33;

    public Label B1;public Label B2;public Label B3;
    public Label Y1;public Label Y2;public Label Y3;

    public Label Yf1;public Label Yf2;public Label Yf3;
    public Label Xf1;public Label Xf2;public Label Xf3;
//Se carga la ventana con sus datos inicializados
    public Resultado(DoolitleP data){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MatrizSuperior.class.getResource("/UI/Resultado.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        this.datos = data;

        try{
            fxmlLoader.load();
            L11.setText(datos.TraerL(0,0)+"");L12.setText(datos.TraerL(0,1)+"");L13.setText(datos.TraerL(0,2)+"");
            L21.setText(datos.TraerL(1,0)+"");L22.setText(datos.TraerL(1,1)+"");L23.setText(datos.TraerL(1,2)+"");
            L31.setText(datos.TraerL(2,0)+"");L32.setText(datos.TraerL(2,1)+"");L33.setText(datos.TraerL(2,2)+"");

            U11.setText(datos.TraerU(0,0)+"");U12.setText(datos.TraerU(0,1)+"");U13.setText(datos.TraerU(0,2)+"");
            U21.setText(datos.TraerU(1,0)+"");U22.setText(datos.TraerU(1,1)+"");U23.setText(datos.TraerU(1,2)+"");
            U31.setText(datos.TraerU(2,0)+"");U32.setText(datos.TraerU(2,1)+"");U33.setText(datos.TraerU(2,2)+"");

            B1.setText(datos.TraerB(0)+"");B2.setText(datos.TraerB(1)+"");B3.setText(datos.TraerB(2)+"");
            Y1.setText(datos.TraerY(0)+"");Y2.setText(datos.TraerY(1)+"");Y3.setText(datos.TraerY(2)+"");

            Yf1.setText(datos.TraerY(0)+"");Yf2.setText(datos.TraerY(1)+"");Yf3.setText(datos.TraerY(2)+"");
            Xf1.setText(datos.TraerX(0)+"");Xf2.setText(datos.TraerX(1)+"");Xf3.setText(datos.TraerX(2)+"");

        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
