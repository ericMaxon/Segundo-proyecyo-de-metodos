import Clases.Principal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Principal raiz = new Principal();
        primaryStage.setScene(new Scene(raiz));
        primaryStage.setTitle("Ventana Principal");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
