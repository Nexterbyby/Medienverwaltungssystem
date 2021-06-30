package ch.bbw;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Converter.Converter;
import ch.bbw.Formatter.TableFormatter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class MainviewController implements Initializable {

    @FXML
    ListView<String> view2;

    @FXML
    private TextField id_text;

    public static int id;

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

        try {
            id = Integer.parseInt(id_text.getText().toString()); //Textfield -> String -> int
        } catch (Exception e){
            id_text.setText("ID ist keine zahl");
        }
        if (App.db_manager.checkMediumID(id)){
            App.setRoot("update_delete_book");
        }else{
            id_text.setText("ID ist nicht vorhanden");
        }

    }
    @FXML
    private void createBook() throws IOException {
        App.setRoot("create_book");
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

    public static int getId() {
        return id;
    }
}
