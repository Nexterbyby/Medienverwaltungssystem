package ch.bbw.Formatter;

import ch.bbw.Model.Genre;

import java.util.List;

/**
 * @author Nexterbyby
 * @since 0.0.1
 * @version 0.0.1
 *
 * Diese Klasse haust die Funktionen die Objektlisten in einen Formatierten String.
 */
public class ListToStringFormatter {
    public ListToStringFormatter(){
        //nothing
    }

    /**
     * Diese Funktion formattiert eine Liste von Genres in einen String mit Kommas. "horror, fantasy"
     * @param genreList Eine Liste von Genres.
     * @return Gibt einen formatierten String zurück.
     */
    public static String format(List<Genre> genreList){
        String list = "";
        if(genreList != null && genreList.size() > 0){
            for(int i = 0; i < genreList.size()-1;i++){
                list += genreList.get(i).getName() + ",";
            }
            list += genreList.get(genreList.size()-1).getName();
            return list;
        }
        return list;
    }
}
