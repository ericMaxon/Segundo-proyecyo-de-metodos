package Clases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class Secante extends AnchorPane {
    private TableView<SecanteP> tableView;
    private TableColumn<SecanteP, Integer> iter;
    private TableColumn <SecanteP, Double> xn;
    private TableColumn <SecanteP, Double> fxn;
    private TableColumn <SecanteP, Double>fxn1;
    private TableColumn <SecanteP, Double> error;
    public Label result;
    private SecanteP secanteP;
    private double resultado;

//    Son generadas las partes de la tabla, al igual que su posicionamiento en la ventana
        public Secante(){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Secante.class.getResource("/UI/Secante.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            iter = new TableColumn<>("iter");
            iter.setPrefWidth(75.0);
            iter.setCellValueFactory(new PropertyValueFactory <SecanteP, Integer>("iterac"));

            xn = new TableColumn<>("xn");
            xn.setPrefWidth(75.0);
            xn.setCellValueFactory(new PropertyValueFactory<SecanteP, Double>("x1"));

            fxn = new TableColumn<>("f(xn)");
            fxn.setPrefWidth(75.0);
            fxn.setCellValueFactory(new PropertyValueFactory<SecanteP, Double>("f_xn"));

            fxn1 = new TableColumn<>("f(xn+1)");
            fxn1.setPrefWidth(75.0);
            fxn1.setCellValueFactory(new PropertyValueFactory<SecanteP, Double>("f_xn1"));

            error = new TableColumn<>("ERAP");
            error.setPrefWidth(75.0);
            error.setCellValueFactory(new PropertyValueFactory<SecanteP, Double>("error"));

            tableView = new TableView<>();
            tableView.setLayoutX(86);
            tableView.setLayoutY(44);
            tableView.setPrefWidth(377);
            tableView.setPrefHeight(286);

            try{
                fxmlLoader.load();
            }catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
//  Se les asgina los datos al objeto de Secante procesos.
    public void cargarDatos(double xn, double xn1){
            secanteP = new SecanteP(xn, xn1);
        }

//  Se generan los datos de nuestra tabla y se envian a como lista observable
    public ObservableList<SecanteP> generarTabla(){
        ArrayList<SecanteP> valores = new ArrayList<>();
        double errTol = 0.0001;
        int limite = 10, i;
        secanteP.setError(1);
        for (i = 0; i <= limite; i++){
            double x0=0,xraux=0;

            if(secanteP.getError()< errTol) break;

            secanteP.setIterac(i);

            if(i >= 1) {
                secanteP.calcF_xn();
                secanteP.calcF_xn1();
                secanteP.calcularError();
                if(i>1) {
                    xraux = secanteP.calcularX();
                    x0 = secanteP.getX1();
                    secanteP.actualizarDatos(x0, xraux);
                }
            }
            valores.add(i,secanteP);
            resultado = secanteP.getX1();
            System.out.println(valores.get(i));
        }

        return FXCollections.observableArrayList(valores);
    }
//    Son cargados los datos del objeto a las celdas de la tabla
    public void inicializarCeldas() {
        tableView.setItems(generarTabla());
        result.setText(" "+resultado);
        tableView.getColumns().addAll(iter, xn,fxn,fxn1,error);
    }
//    Es enviada la tabla a la clase principal, para que pueda ser mostrada
    public TableView<SecanteP> obtenerTabla(){
            inicializarCeldas();
            return tableView;
    }

}
