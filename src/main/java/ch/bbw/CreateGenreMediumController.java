package ch.bbw;

import ch.bbw.Model.Genre;
import ch.bbw.Model.Kaufort;
import ch.bbw.Model.Medium;
import ch.bbw.Model.Sprache;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateGenreMediumController implements Initializable {
    @FXML
    ChoiceBox<Medium> medium;
    @FXML
    ChoiceBox<Genre> genre;

    /**
     * Methode um Genre und Medium zu verbinden und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void createRelation() throws IOException {
        App.db_manager.connect(genre.getValue(), medium.getValue());
        App.setRoot("mainview");
    }

    /**
     * Methode um zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void cancel() throws IOException{
        App.setRoot("mainview");
    }


    /**
     * Methode um die Medien und Genre zu Initialization.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Medium m:
                App.db_manager.getAllMedia()) {
            medium.getItems().add(m);
        }
        for (Genre g: App.db_manager.getAllGenres()){
            genre.getItems().add(g);
        }
    }
}
