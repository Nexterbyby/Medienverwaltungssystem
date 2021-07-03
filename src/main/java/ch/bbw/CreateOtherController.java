package ch.bbw;

import ch.bbw.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateOtherController {

    @FXML
    private TextField name;

    /**
     * Methode um zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void cancel() throws IOException {
        App.setRoot("mainview");
    }

    /**
     * Methode um den Text zu Genre hinzuzufügen und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void addGenre() throws IOException{
        Genre genre = new Genre(name.getText());
        App.db_manager.saveGenre(genre);
        App.setRoot("mainview");
    }

    /**
     * Methode um den Text zu Kaufort hinzuzufügen und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void addKaufort() throws IOException{
        Kaufort kaufort = new Kaufort(name.getText());
        App.db_manager.saveKaufort(kaufort);
        App.setRoot("mainview");
    }

    /**
     * Methode um den Text zu Verlag hinzuzufügen und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void addVerlag() throws IOException{
        Verlag verlag = new Verlag(name.getText());
        App.db_manager.saveVerlag(verlag);
        App.setRoot("mainview");
    }

    /**
     * Methode um den Text zu Typ hinzuzufügen und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void addTyp() throws IOException{
        Typ typ = new Typ(name.getText());
        App.db_manager.saveTyp(typ);
        App.setRoot("mainview");
    }

    /**
     * Methode um den Text zu Sprache hinzuzufügen und zurück zu MainviewController zu kommen.
     * @throws IOException
     */
    @FXML
    public void addSprache() throws IOException{
        Sprache sprache = new Sprache(name.getText());
        App.db_manager.saveSprache(sprache);
        App.setRoot("mainview");
    }

}
