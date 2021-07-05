package ch.bbw.Formatter;

import ch.bbw.Model.Genre;
import ch.bbw.Model.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nexterbyby
 * @version 0.0.1 14.06.2021
 * @since 0.0.1 14.06.2021
 *
 * Diese Klasse enthält Funktionen die mit Tabellenformatierung zu tun haben.
 */
public class TableFormatter {
    public TableFormatter(){
        // nothing
    }

    /**
     * Diese Funktion nimmt Medium Datensätze und formattiert sie in eine Tabelle zur visualisierung.
     * @param datasets Eine Liste mit Medium Objekten.
     * @return Gibt eine String zurück im Tabellen Format.
     */
    public static String formatTableMedium(List<Medium> datasets){
        String out = "";
        out += String.format("%-5s %-60s %-29s %-25s %-15s %-15s %-30s %-15s %-50s %-20s\n",
                "id",
                "name",
                "buy_date",
                "buy_place",
                "price",
                "language",
                "publisher",
                "type",
                "comment",
                "genre");

        for(Medium m : datasets) {
            out += String.format("%-5s %-60s %-29s %-25s %-15s %-15s %-30s %-15s %-50s %-20s\n",
                    m.getMedium_id() + "",
                    m.getName(),
                    m.getKaufdatum(),
                    m.getKaufort().getName(),
                    m.getPreis() + "",
                    m.getSprache().getName(),
                    m.getVerlag().getName(),
                    m.getTyp().getName(),
                    m.getKommentar(),
                    m.getGenres());
        }
        return out;
    }
}
