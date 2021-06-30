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

public class CreateGenreMediumController implements Initializable {
    @FXML
    ChoiceBox<Medium> medium;
    @FXML
    ChoiceBox<Genre> genre;

    @FXML
    public void createRelation() throws IOException {
        App.db_manager.connectGenreMedium(genre.getValue(), medium.getValue());
        App.setRoot("mainview");
    }
    @FXML
    public void cancel() throws IOException{
        App.setRoot("mainview");
    }


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
