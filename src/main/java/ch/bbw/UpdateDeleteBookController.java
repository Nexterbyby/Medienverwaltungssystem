package ch.bbw;

import java.io.IOException;
import javafx.fxml.FXML;

public class UpdateDeleteBookController {

    @FXML
    private void switchToMainview() throws IOException {
        App.setRoot("mainview");
    }
}