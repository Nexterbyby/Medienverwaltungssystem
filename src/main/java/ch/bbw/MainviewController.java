package ch.bbw;

import java.io.IOException;

import ch.bbw.DBManager.DatabaseManager;
import javafx.fxml.FXML;

public class MainviewController {
    private DatabaseManager db_manager = new DatabaseManager();

    public MainviewController(){
        db_manager.startup();
    }

    @FXML
    private void editBook() throws IOException {
        App.setRoot("update_delete_book");
    }
    @FXML
    private void createBook() throws IOException {
        App.setRoot("create_book");
    }
    @FXML
    private void editGame() throws IOException {
        App.setRoot("update_delete_game");
    }
    @FXML
    private void createGame() throws IOException {
        App.setRoot("create_Game");
    }
    @FXML
    private void actionHibernate(){

    }
}
