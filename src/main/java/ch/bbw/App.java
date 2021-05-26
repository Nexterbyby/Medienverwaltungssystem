package ch.bbw;

import ch.bbw.Model.Medium;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainview"), 640, 480);
        stage.setScene(scene);
        stage.show();
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
        EntityManagerFactory psfactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        EntityManager entitymanager = psfactory.createEntityManager();

        entitymanager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Medium> listMedium = entitymanager.createNamedQuery("Medium.findAll").getResultList();

        entitymanager.getTransaction().commit();
        entitymanager.close();
        psfactory.close();

        if (listMedium == null) {
            System.out.println("No medium found");
        } else {
            for (Medium ps : listMedium) {
                System.out.println(ps);
            }
            launch();
        }

    }
}