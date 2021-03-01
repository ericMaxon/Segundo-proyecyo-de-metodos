package Clases;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

/*
* Se encuentra el llamado a todas las ventana o menus correspondientes
* Es la encargada asignar y accedar a las ventanas de los menus
* */
public class Principal extends AnchorPane {
    private Doolitle DoolitleBase;
    private Secante SecanteBase;
    private Biseccion BiseccionBase;
    private InsercionIntervalos InsercionBase;
    private Stage doolitle;
    private Stage insertar;
//  Atributos necesarios para la interaccion entre ventanas
//  Se crea y carga la ventana principal con sus botones u opciones
    public Principal(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Objects.requireNonNull(Principal.class.getResource("/UI/Principal.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
        DoolitleBase = new Doolitle();//Son inicializados para darle mas dinamismo
        doolitle = new Stage();
        InsercionBase = new InsercionIntervalos();
        insertar = new Stage();
    }

    public void Presentacion(MouseEvent mouseEvent) throws Exception {
        Parent PresentacionBase = FXMLLoader.load(getClass().getClassLoader().getResource("UI/Presentacion.fxml"));
        Stage presentacion = new Stage();
        presentacion.initModality(Modality.APPLICATION_MODAL);
        presentacion.setTitle("Presentacion");
        presentacion.setScene(new Scene(PresentacionBase));
        presentacion.showAndWait();
    }
    public void Doolitle(MouseEvent mouseEvent){
        //Este if se realizo para evitar los errores de nullPointerException o que
//        ya existe la escena
        if(doolitle.getScene()==null){
            doolitle.setTitle("Doolitle");
            doolitle.setScene(new Scene(DoolitleBase));
            doolitle.initModality(Modality.APPLICATION_MODAL);
        }
        doolitle.showAndWait();
    }
    public void Insertarfuncion(MouseEvent mouseEvent) {
        if(insertar.getScene() == null) {
            insertar.setTitle("Insertar intervalo");
            insertar.setScene(new Scene(InsercionBase));
            insertar.initModality(Modality.APPLICATION_MODAL);
        }
        insertar.showAndWait();
    }
    public void Biseccion(MouseEvent mouseEvent) {
        //Para verificar que el usuario haya entrado a realizar la insercion del intervalo
        if(InsercionBase == null) {
            Alerta.mostrar("Datos no ingresados","Dirijase al recuadro insertar intervalos e ingrese los intervalos");
        }else {
            if(BiseccionP.hayCambioEn(InsercionBase.a,InsercionBase.b)){
                BiseccionBase = new Biseccion();
                BiseccionP.AsignarCoef(InsercionBase.c1,InsercionBase.c2,InsercionBase.c3,InsercionBase.ind);
                BiseccionBase.cargarData(InsercionBase.a, InsercionBase.b);
                TableView tableView = BiseccionBase.obtenerTabla();
                BiseccionBase.getChildren().add(tableView);
                Stage biseccion = new Stage();
                biseccion.initModality(Modality.APPLICATION_MODAL);
                biseccion.setTitle("Biseccion");
                biseccion.setScene(new Scene(BiseccionBase));
                biseccion.show();
            }else{
                Alerta.mostrar("No hay cambio en la funcion","Intente con un nuevo intervalo");
            }
        }
    }
    public void Secante(MouseEvent mouseEvent) {
        //Para verificar que el usuario haya entrado a realizar la insercion del intervalo
        if(InsercionBase == null) {
            Alerta.mostrar("Datos no ingresados","Dirijase al recuadro insertar intervalos e ingrese los intervalos");
        }else {
            SecanteBase = new Secante();
            SecanteP.AsignarCoef(InsercionBase.c1,InsercionBase.c2,InsercionBase.c3,InsercionBase.ind);
            SecanteBase.cargarDatos(InsercionBase.a, InsercionBase.b);
            
            SecanteBase.getChildren().add(SecanteBase.obtenerTabla());
            Stage secante = new Stage();
            secante.initModality(Modality.APPLICATION_MODAL);
            secante.setTitle("Secante");
            secante.setScene(new Scene(SecanteBase));
            secante.show();
        }
    }

}
