package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Converter.Converter;
import ch.bbw.Formatter.TableFormatter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainviewController implements Initializable {

    @FXML
    ListView<String> view2;

    Converter converter;

    public MainviewController(){
        System.out.println("MVC called");
        if(!App.db_manager.isAlive()){
            App.db_manager.startup();
        }else{
            System.out.println("db_manager already alive");
        }
        this.converter = new Converter();
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
    @FXML
    private void createCSV(){
        converter.convertToCSV();
    }
    @FXML
    private void createExcel(){
        converter.convertToExcel();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(App.db_manager.getAllMedia().toString()); //print in console
        String list = TableFormatter.formatTableMedium(App.db_manager.getAllMedia());
        view2.getItems().add(list); // print in List View
    }
}
