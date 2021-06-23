package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import ch.bbw.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateDeleteBookController implements Initializable {

    @FXML
    private void switchToMainview() throws IOException {
        if(ccurrenttime.isSelected()){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Timestamp s = Timestamp.valueOf(now.format(f));
            Medium replaceMedium = new Medium( s,ename.getText(), Double.parseDouble(epreis.getText()), csprache.getValue(),
                    cverlag.getValue(), ckaufort.getValue(), ctyp.getValue(), ekommentar.getText());
            App.db_manager.updateMedium(MainviewController.id, replaceMedium);
        } else {
            Medium replaceMedium = new Medium(App.db_manager.getMedia(MainviewController.id).getKaufdatum(), ename.getText(), Double.parseDouble(epreis.getText()), csprache.getValue(),
                    cverlag.getValue(), ckaufort.getValue(), ctyp.getValue(), ekommentar.getText());
            App.db_manager.updateMedium(MainviewController.id, replaceMedium);
        }


        App.setRoot("mainview");
    }

    @FXML
    private ChoiceBox<Sprache> csprache = new ChoiceBox<Sprache>();
    @FXML
    private ChoiceBox<Kaufort> ckaufort = new ChoiceBox<Kaufort>();
    @FXML
    private ChoiceBox<Typ> ctyp = new ChoiceBox<Typ>();
    @FXML
    private ChoiceBox<Verlag> cverlag = new ChoiceBox<Verlag>();
    @FXML
    private TextField ename, epreis, ekommentar;
    @FXML
    private CheckBox ccurrenttime;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Sprache s:
                App.db_manager.getAllSprachen()) {
            csprache.getItems().add(s);
        }
        for (Kaufort k: App.db_manager.getAllKauforte()){
            ckaufort.getItems().add(k);
        }
        for (Typ t: App.db_manager.getAllTypen()){
            ctyp.getItems().add(t);
        }
        for (Verlag v: App.db_manager.getAllVerlaege()){
            cverlag.getItems().add(v);
        }

        //FIRST TRY GET ID PUT TO PRESELECT
        ename.setText(App.db_manager.getMedia(MainviewController.id).getName());
        epreis.setText(App.db_manager.getMedia(MainviewController.id).getPreis().toString());
        ekommentar.setText(App.db_manager.getMedia(MainviewController.id).getKommentar());
        csprache.setValue(App.db_manager.getMedia(MainviewController.id).getSprache());
        ckaufort.setValue(App.db_manager.getMedia(MainviewController.id).getKaufort());
        ctyp.setValue(App.db_manager.getMedia(MainviewController.id).getTyp());
        cverlag.setValue(App.db_manager.getMedia(MainviewController.id).getVerlag());
    }
}