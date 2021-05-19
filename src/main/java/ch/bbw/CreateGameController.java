package ch.bbw;

import javafx.fxml.FXML;

import java.io.IOException;

public class CreateGameController {
    @FXML
    private void createGame() throws IOException {
        App.setRoot("mainview");
    }
}
