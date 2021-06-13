package ch.bbw;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateBookController {

    @FXML
    private TextField fld1;
    @FXML
    private TextField fld2;
    @FXML
    private TextField fld3;
    @FXML
    private TextField fld4;
    @FXML
    private TextField fld5;
    @FXML
    private TextField fld6;
    @FXML
    private TextField fld7;
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
                fld2.getText(),
                fld3.getText(),
                fld4.getText(),
                fld5.getText(),
                fld6.getText(),
                fld7.getText(),
                fld8.getText()
        };
    }
}
