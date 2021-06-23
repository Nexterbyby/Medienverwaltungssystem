package ch.bbw.Converter;

import ch.bbw.Model.Medium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import ch.bbw.App;

/**
 * @author Nexterbyby
 * @version 0.0.1 23.06.2021
 * @since 0.0.1 23.06.2021
 *
 * The Main table of the database will be converted into different formats file
 * that will be stored in the users download folder.
 */
public class Converter {

    public Converter(){

    }

    public void convert() throws IOException{
        File output = new File("C:\\Users\\" + System.getProperty("user.name") +
                "\\Downloads" + "\\" + System.currentTimeMillis() + ".txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
        List<Medium> mediumList = App.db_manager.getAllMedia();
        String out = "";
        for(Medium m : mediumList){
            out += m.getMedium_id() + ";" +
                   m.getName() + ";" +
                   m.getKaufdatum() + ";"+
                   m.getKaufort().getName() + ";" +
                   m.getPreis() + ";" +
                   m.getSprache().getName() + ";" +
                   m.getVerlag().getName() + ";" +
                   m.getTyp().getName() + ";" +
                   m.getKommentar()
                   ;
        }
        bufferedWriter.write(out);
        bufferedWriter.close();
    }
}
