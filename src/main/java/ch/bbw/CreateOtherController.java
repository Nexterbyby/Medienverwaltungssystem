package ch.bbw;

import ch.bbw.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateOtherController {

    @FXML
    private TextField name;

    @FXML
    public void cancel() throws IOException {
        App.setRoot("mainview");
    }

    @FXML
    public void addGenre() throws IOException{
        Genre genre = new Genre(name.getText());
        App.db_manager.saveGenre(genre);
        App.setRoot("mainview");
    }

    @FXML
    public void addKaufort() throws IOException{
        Kaufort kaufort = new Kaufort(name.getText());
        App.db_manager.saveKaufort(kaufort);
        App.setRoot("mainview");
    }

    @FXML
    public void addVerlag() throws IOException{
        Verlag verlag = new Verlag(name.getText());
        App.db_manager.saveVerlag(verlag);
        App.setRoot("mainview");
    }

    @FXML
    public void addTyp() throws IOException{
        Typ typ = new Typ(name.getText());
        App.db_manager.saveTyp(typ);
        App.setRoot("mainview");
    }

    @FXML
    public void addSprache() throws IOException{
        Sprache sprache = new Sprache(name.getText());
        App.db_manager.saveSprache(sprache);
        App.setRoot("mainview");
    }

}
