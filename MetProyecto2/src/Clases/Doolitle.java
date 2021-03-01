package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/*
*
* Controlador de las ventana necesarias para el proceso del metodo Doolitle
*
* */
public class Doolitle extends AnchorPane {
    protected DoolitleP procesos;
    protected MatrizPrincipal matrizP;
    protected Stage matriz;
//  Se carga la ventana principal del Metodo Doolitle
    public Doolitle(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Objects.requireNonNull(Doolitle.class.getResource("/UI/Doolitle.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        procesos = new DoolitleP();
        try{
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
        matrizP = new MatrizPrincipal();
        matriz = new Stage();
    }

    public void MatrizPrincipal(MouseEvent mouseEvent) throws Exception {
        /*Para evitar que se genere un error de que ya existe la escena
        A su vez para controlar que se haya accedido a esta ventana*/
            if(matriz.getScene()==null) {
                matriz.setTitle("Matriz");
                matriz.setScene(new Scene(matrizP));
                matriz.initModality(Modality.APPLICATION_MODAL);
            }
        matriz.showAndWait();
        //Para verificar que el usuario haya ingresados todos sus datos (funcion algo defectuosa)
        if(matrizP.hayDatos()) {
            procesos = matrizP.traerData();
            procesos.CreacionTriangulos();
            procesos.calcularY();
            procesos.calcularX();
        }
    }

    public void MatrizInf(MouseEvent mouseEvent) {
        //Si no se ha accedido a la matriz principal
        if(matriz.getScene() !=null&& matrizP.hayDatos()) {
            MatrizInferior matrizInferior = new MatrizInferior(procesos);
            Stage matrizInf = new Stage();
            matrizInf.initModality(Modality.APPLICATION_MODAL);
            matrizInf.setTitle("Matriz Inferior");
            matrizInf.setScene(new Scene(matrizInferior));
            matrizInf.showAndWait();
        }else{
            Alerta.mostrar("No hay datos", "Debe ingresar los datos en la matriz principal");
        }
    }

    public void MatrizSup(MouseEvent mouseEvent) {
        //Si no se ha accedido a la matriz principal
        if(matriz.getScene() !=null && matrizP.hayDatos()) {
            MatrizSuperior matrizSuperior = new MatrizSuperior(procesos);
            Stage matrizSup = new Stage();
            matrizSup.initModality(Modality.APPLICATION_MODAL);
            matrizSup.setTitle("Matriz Superior");
            matrizSup.setScene(new Scene(matrizSuperior));
            matrizSup.showAndWait();
        }else{
            Alerta.mostrar("No hay datos", "Debe ingresar los datos en la matriz principal");
        }
    }

    public void Resultado(MouseEvent mouseEvent) {
        //Si no se ha accedido a la matriz principal
        if(matriz.getScene() !=null && matrizP.hayDatos()) {
            Resultado resultado = new Resultado(procesos);
            Stage result = new Stage();
            result.initModality(Modality.APPLICATION_MODAL);
            result.setTitle("Resultado");
            result.setScene(new Scene(resultado));
            result.showAndWait();
        }else{
            Alerta.mostrar("No hay datos", "Debe ingresar los datos en la matriz principal");
        }
    }
}
