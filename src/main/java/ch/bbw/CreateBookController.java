package ch.bbw;

import ch.bbw.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateBookController implements Initializable {

    @FXML
    private TextField fld1;
    @FXML
    private CheckBox currentdate;
    @FXML
    private TextField fld3;
    @FXML
    private ChoiceBox<Sprache> csparche;
    @FXML
    private ChoiceBox<Verlag> cpublisher;
    @FXML
    private ChoiceBox<Kaufort> ckaufort;
    @FXML
    private ChoiceBox<Typ> ctyp;
    @FXML
    private TextField fld8;


    /**
     * Methode um die Daten in MariaDB hineinzuwerfen und danach nach MainviewController wechseln
     * @throws IOException
     */
    @FXML
    private void submit() throws IOException{
        if (currentdate.isSelected()) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Timestamp s = Timestamp.valueOf(now.format(f));
            Medium medium = new Medium( s, fld1.getText(), Double.parseDouble(fld3.getText()),csparche.getValue(), cpublisher.getValue(),
                    ckaufort.getValue(), ctyp.getValue(), fld8.getText());
            App.db_manager.saveMedium(medium);
        } else{
            Medium medium = new Medium(fld1.getText(), Double.parseDouble(fld3.getText()),csparche.getValue(), cpublisher.getValue(),
                    ckaufort.getValue(), ctyp.getValue(), fld8.getText());
            App.db_manager.saveMedium(medium);
        }
        App.setRoot("mainview");
    }

    /**
     * Methode um zurück in die MainviewController zu kommen ohne Daten in MariaDB zu tun.
     * @throws IOException
     */
    @FXML
    private void discard() throws IOException{
        App.setRoot("mainview");
    }

    /**
     * Methode um in CreateOtherController zu kommen.
     * @throws IOException
     */
    @FXML
    public void createOther() throws IOException {
        App.setRoot("create_other");
    }

    /**
     * Methode um in ConnectGenreMedium zu kommen.
     * @throws IOException
     */
    @FXML
    public void connectGenreMedium() throws IOException{
        App.setRoot("create_genre_medium");
    }

    /**
     * Methode für Initialization der Daten von der MariaDB
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Sprache s:
                App.db_manager.getAllSprachen()) {
            csparche.getItems().add(s);
        }
        for (Kaufort k: App.db_manager.getAllKauforte()){
            ckaufort.getItems().add(k);
        }
        for (Typ t: App.db_manager.getAllTypen()){
            ctyp.getItems().add(t);
        }
        for (Verlag v: App.db_manager.getAllVerlaege()){
            cpublisher.getItems().add(v);
        }
    }
}
