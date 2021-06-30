package ch.bbw.Formatter;

import ch.bbw.Model.Genre;

import java.util.ArrayList;
import java.util.List;

public class ListToStringFormatter {
    public ListToStringFormatter(){
        //nothing
    }

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
