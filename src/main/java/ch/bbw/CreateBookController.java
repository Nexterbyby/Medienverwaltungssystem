package ch.bbw;

import ch.bbw.Model.Kaufort;
import ch.bbw.Model.Sprache;
import ch.bbw.Model.Verlag;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateBookController {

    @FXML
    private TextField fld1;
    @FXML
    private CheckBox currentdate;
    @FXML
    private TextField fld3;
    @FXML
    private ChoiceBox<Sprache> csprache;
    @FXML
    private ChoiceBox<Verlag> cpublisher;
    @FXML
    private ChoiceBox<Kaufort> ckaufort;
    @FXML
    private TextField fld8;


    @FXML
    private void createData() throws IOException {
        App.setRoot("mainview");
    }

    @FXML
    private void submit(){
        String [] fields = getFields();
        for(int i = 0; i < 8; i++){
            System.out.println(fields[i]);
        }
    }

    @FXML
    private void discard() throws IOException{
        App.setRoot("mainview");
    }

    private String [] getFields(){
        return new String[]{
                fld1.getText(),
                fld3.getText(),
                fld8.getText()
        };
    }

}
