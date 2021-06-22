package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ch.bbw.DBManager.DatabaseManager;
import ch.bbw.Formatter.TableFormatter;
import ch.bbw.Model.Medium;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;

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
        String list = TableFormatter.formatTableMedium(App.db_manager.getAllMedia());
        /*
        for (Medium m:
             App.db_manager.getAllMedia()) {
            String list2 = m.toString();
            view2.getItems().add(list2);
        }
         */
        System.out.println(App.db_manager.getAllGenres());
        //String list2 = TableFormatter.formatTableGenre(App.db_manager.getAllGenres()).toString();
        view2.getItems().add(list); // print in List View
        //view2.getItems().add(list2);
    }
}
