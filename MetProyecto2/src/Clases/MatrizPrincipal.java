package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
/*Esta clase controla la ventana MatrizPrincipal
* A su vez es donde se ingresan los datos de la matriz*/
public class MatrizPrincipal extends AnchorPane {
    public TextField celda1;
    public TextField celda2;
    public TextField celda3;
    public TextField celda4;
    public TextField celda5;
    public TextField celda6;
    public TextField celda7;
    public TextField celda8;
    public TextField celda9;
    public TextField b1;
    public TextField b2;
    public TextField b3;
    private DoolitleP doolitleP;
//Se carga la ventana de la matriz
    public MatrizPrincipal(){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MatrizPrincipal.class.getResource("/UI/MatrizPrincipal.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try{
                fxmlLoader.load();
            }catch (IOException exception){
                throw new RuntimeException(exception);
            }
        }
//  Metodo accionable por el usuario para enviar los datos
    public void enviarData(MouseEvent mouseEvent) {
        DoolitleP asigProc = new DoolitleP();//asigProc quiere decir proceso de asignacion
        asigProc.Asignar(celda1.getText(),0,0);asigProc.Asignar(celda2.getText(),0,1);asigProc.Asignar(celda3.getText(),0,2); asigProc.Asignar(b1.getText(), 0);
        asigProc.Asignar(celda4.getText(),1,0);asigProc.Asignar(celda5.getText(),1,1);asigProc.Asignar(celda6.getText(),1,2);asigProc.Asignar(b2.getText(), 1);
        asigProc.Asignar(celda7.getText(),2,0);asigProc.Asignar(celda8.getText(),2,1);asigProc.Asignar(celda9.getText(),2,2); asigProc.Asignar(b3.getText(), 2);
        this.celda1.setPromptText(asigProc.TraerA(0,0)+"");this.celda2.setPromptText(asigProc.TraerA(0,1)+"");this.celda3.setPromptText(asigProc.TraerA(0,2)+"");
        this.celda4.setPromptText(asigProc.TraerA(1,0)+"");this.celda5.setPromptText(asigProc.TraerA(1,1)+"");this.celda6.setPromptText(asigProc.TraerA(1,2)+"");
        this.celda7.setPromptText(asigProc.TraerA(2,0)+"");this.celda8.setPromptText(asigProc.TraerA(2,1)+"");this.celda9.setPromptText(asigProc.TraerA(2,2)+"");
        doolitleP = asigProc;
        Alerta.mostrar("Enviado", "Se han enviado correctamente los datos");
    }
    /*Verifica que este ingresados todos los datos o algunos de ellos.
    Este metodo no se perfecciono debido a que la unica conocida era
    agregar al menos 100+ distintas posibilidades de falta de datos en las
    celdas.*/
    public boolean hayDatos(){
        return !(celda1.getText().equals("") && celda2.getText().equals("") && celda3.getText().equals("") && b1.getText().equals("")&&
                celda4.getText().equals("") && celda5.getText().equals("") && celda6.getText().equals("")&& b2.getText().equals("")&&
                celda7.getText().equals("") && celda8.getText().equals("") && celda9.getText().equals("")&& b3.getText().equals(""));
    }
    public DoolitleP traerData(){
        return doolitleP;
    }
}
