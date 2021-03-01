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
import java.util.Objects;

public class Biseccion extends AnchorPane {
    //Gran parte de las lineas hubieran sido minimizada si no se hubiera generado muchos errores con el SceneBbuilder
    private TableView<BiseccionP> tableView;
    private TableColumn <BiseccionP, Integer> iter;
    private TableColumn <BiseccionP, Double> a;
    private TableColumn <BiseccionP, Double> b;
    private TableColumn <BiseccionP, Double> x;
    private TableColumn <BiseccionP, Double> f_a;
    private TableColumn<BiseccionP, Double> f_xr;
    private TableColumn <BiseccionP, Double> f_ax;
    private TableColumn <BiseccionP, Double> error;
    private BiseccionP operacion;
    public Label result;
    private double resultado;

//    Aqui se establecen las partes de la tabla a generar
    public Biseccion(){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Objects.requireNonNull(Biseccion.class.getResource("/UI/Biseccion.fxml")));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

        iter = new TableColumn<>("#Iter");
        iter.setPrefWidth(75.0);
        iter.setCellValueFactory(new PropertyValueFactory<BiseccionP, Integer>("iter"));

        a = new TableColumn<>("a");
        a.setPrefWidth(75.0);
        a.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("a"));

        b = new TableColumn<>("b");
        b.setPrefWidth(75.0);
        b.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("b"));

        x = new TableColumn<>("xr");
        x.setPrefWidth(75.0);
        x.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("xr"));

        f_a = new TableColumn<>("f(a)");
        f_a.setPrefWidth(75.0);
        f_a.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("f_a"));

        f_xr = new TableColumn<>("f(xr)");
        f_xr.setPrefWidth(75.0);
        f_xr.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("f_xr"));

        f_ax = new TableColumn<>("f(a) * f(x)");
        f_ax.setPrefWidth(75.0);
        f_ax.setCellValueFactory(new PropertyValueFactory<BiseccionP, Double>("f_ax"));

        error = new TableColumn<>("ERAP");
        error.setPrefWidth(75.0);
        error.setCellValueFactory(new PropertyValueFactory<BiseccionP,Double>("error"));

        tableView = new TableView<>();
        tableView.setLayoutX(20);
        tableView.setLayoutY(40);
        tableView.setPrefHeight(335);
        tableView.setPrefWidth(595);
            try{
                fxmlLoader.load();
            }catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        resultado = 0;
        }
// Envia los datos al objeto de la clase Biseccion procesos
    public void cargarData(double a, double b){
        operacion = new BiseccionP(a,b);
    }
//    Se genera la tabla con sus datos, mediante una lista observable
//    para luego ser accedida por las partes de la tabla
    public ObservableList<BiseccionP> generarTabla(){
        ObservableList<BiseccionP> lista = FXCollections.observableArrayList();

        operacion.calcXr();
        operacion.calcF_a();
        operacion.calcF_xr();

        operacion.calcF_ax();
        operacion.calcError(0);//Se inicializa en cero el primer error ya que no hay datos anteriores

        double errTol = 0.0001;
        for(int i = 0; operacion.getError()> errTol; i++){
            double a=0, b=0,xraux=0;
            operacion.setIter(i);//Se asigna el valor a iteraccion
            resultado = operacion.getXr();
            lista.add(operacion);

            if (operacion.vaNegativo()) b= operacion.getXr(); else b = operacion.getB();
            if(operacion.vaPositivo()) a= operacion.getXr(); else a= operacion.getA();
            xraux = operacion.getXr();

            cargarData(a,b);
            operacion.calcXr();
            operacion.calcF_a();
            operacion.calcF_xr();
            operacion.calcF_ax();
            operacion.calcError(xraux);//En este punto se calcula el error con xraux que representa al xr anterior
        }
        return lista;
    }
//    Se inicializan las celdas de la tabla
    public void inicializarCeldas(){
        tableView.setItems(generarTabla());
        result.setText(" "+resultado);
        tableView.getColumns().addAll(iter,a,b,x,f_a,f_xr,f_ax,error);
    }
//    Se envia la tabla generada
    public TableView<BiseccionP> obtenerTabla(){
            inicializarCeldas();
            return tableView;
    }

}
