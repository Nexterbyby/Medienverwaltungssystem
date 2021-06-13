package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.DBManager.DatabaseManager;
import ch.bbw.Model.Medium;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainviewController implements Initializable {
    private DatabaseManager db_manager = new DatabaseManager();

    @FXML
    ListView<String> view2;

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
    public void actionHibernate(){
        System.out.println(db_manager.getAllMedia().toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        view2.getItems().add( db_manager.getAllMedia().toString());
    }
}
