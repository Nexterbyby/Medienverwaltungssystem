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

    @FXML
    ListView<String> view2;

    public MainviewController(){
        System.out.println("MVC called");
        if(!App.db_manager.isAlive()){
            App.db_manager.startup();
        }else{
            System.out.println("db_manager already alive");
        }
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
        //nothing
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(App.db_manager.getAllMedia().toString()); //print in console
        view2.getItems().add(App.db_manager.getAllMedia().toString()); // print in List View
    }
}
