package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Model.Kaufort;
import ch.bbw.Model.Sprache;
import ch.bbw.Model.Typ;
import ch.bbw.Model.Verlag;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateDeleteBookController implements Initializable {

    @FXML
    private void switchToMainview() throws IOException {
        App.setRoot("mainview");
    }

    @FXML
    private ChoiceBox<String> csprache = new ChoiceBox<String>();
    @FXML
    private ChoiceBox<String> ckaufort = new ChoiceBox<String>();
    @FXML
    private ChoiceBox<String> ctyp = new ChoiceBox<String>();
    @FXML
    private ChoiceBox<String> cverlag = new ChoiceBox<String>();
    @FXML
    private TextField ename, epreis, ekommentar;
    @FXML
    private CheckBox ccurrenttime;

    private MainviewController mvc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Sprache s:
                App.db_manager.getAllSprachen()) {
            csprache.getItems().add(s.toString());
        }
        for (Kaufort k: App.db_manager.getAllKauforte()){
            ckaufort.getItems().add(k.toString());
        }
        for (Typ t: App.db_manager.getAllTypen()){
            ctyp.getItems().add(t.toString());
        }
        for (Verlag v: App.db_manager.getAllVerlaege()){
            cverlag.getItems().add(v.toString());
        }

        //FIRST TRY GET ID PUT TO PRESELECT
        ename.setText(App.db_manager.getMedia(MainviewController.id).getName());
        epreis.setText(App.db_manager.getMedia(MainviewController.id).getPreis().toString());
        ekommentar.setText(App.db_manager.getMedia(MainviewController.id).getKommentar());
        csprache.setValue(App.db_manager.getMedia(MainviewController.id).getSprache().toString());
        ckaufort.setValue(App.db_manager.getMedia(MainviewController.id).getKaufort().toString());
        ctyp.setValue(App.db_manager.getMedia(MainviewController.id).getTyp().toString());
        cverlag.setValue(App.db_manager.getMedia(MainviewController.id).getVerlag().toString());
    }
}