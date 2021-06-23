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
    private TextField ename, epreis, ekommentar, eseite;
    @FXML
    private CheckBox ccurrenttime;


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


    }
}