package ch.bbw;

import ch.bbw.DBManager.DatabaseManager;
import ch.bbw.Model.Medium;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ch.bbw.DBManager.DatabaseManager;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private MainviewController mainviewController = new MainviewController();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainview"), 640, 480);
        stage.setScene(scene);
        stage.show();
        mainviewController.actionHibernate();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.out.println("Person yeets...");
        launch();
    }
}