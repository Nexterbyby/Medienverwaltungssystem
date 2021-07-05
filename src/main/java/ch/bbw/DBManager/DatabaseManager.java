package ch.bbw.DBManager;

import ch.bbw.Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Nexterbyby
 * @version 0.0.1 02.06.2021
 * @since 0.0.1 02.06.2021
 * This inserts, update, deletes and reads datasets from
 * the database.
 */
public class DatabaseManager{
    private EntityManagerFactory emFactory;
    private EntityManager manager;
    private boolean alive;

    public DatabaseManager(){
        System.out.println("DatabaseManager init");
    }

    /**
     * Diese Funktion stellt die Verbindung zur Datenbank her.
     * Sie überprüft auch ob die Datenbank schon am laufen ist.
     */
    public void startup(){
        try{
            this.emFactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
            this.manager = emFactory.createEntityManager();
            this.alive = true;
        }catch (Exception e){
            System.out.println("startup() failed");
        }
    }

    /**
     * Diese Funktion schliesst die Verbindung zur Datenbank.
     */
    public void closeup(){
        this.emFactory.close();
        this.manager.close();
    }

    // +-------------------------------------------------------------------+
    // | READ OPERATIONS                                                   |
    // +-------------------------------------------------------------------+

    /**
     * Diese Funktion hohlt von der Datenbank alle Genres.
     * @return Eine Liste von Genre Objekten.
     */
    public List<Genre> getAllGenres(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Genre> genres = manager.createQuery("SELECT o FROM Genre o").getResultList();
        manager.getTransaction().commit();
        return genres;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Kauforte.
     * @return Eine Liste von Kaufort Objekten.
     */
    public List<Kaufort> getAllKauforte(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Kaufort> kauforte = manager.createQuery("SELECT o FROM Kaufort o").getResultList();
        manager.getTransaction().commit();
        return kauforte;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Medien.
     * @return Eine Liste von Medium Objekten.
     */
    public List<Medium> getAllMedia(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Medium> medien = manager.createQuery("SELECT o FROM Medium o").getResultList();
        manager.getTransaction().commit();
        return medien;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Sprachen.
     * @return Eine Liste von Sprache Objekten.
     */
    public List<Sprache> getAllSprachen(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Sprache> sprachen = manager.createQuery("SELECT o FROM Sprache o").getResultList();
        manager.getTransaction().commit();
        return sprachen;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Typen.
     * @return Eine Liste von Typ Objekten.
     */
    public List<Typ> getAllTypen(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Typ> typen = manager.createQuery("SELECT o FROM Typ o").getResultList();
        manager.getTransaction().commit();
        return typen;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Publisher/Verläge.
     * @return Eine Liste von Verlag Objekten.
     */
    public List<Verlag> getAllVerlaege(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Verlag> verlaege = manager.createQuery("SELECT o FROM Verlag o").getResultList();
        manager.getTransaction().commit();
        return verlaege;
    }

    /**
     * Diese Funktion hohlt von der Datenbank alle Genres.
     * @param id Id ist Suchparameter um den Datensatz zu finden.
     * @return Eine Medium Objekt.
     */
    public Medium getMedia(int id){
        Medium xMedium = manager.find(Medium.class, id);
        return xMedium;
    }


    // +-------------------------------------------------------------------------------------+
    // | SAVE OPERATIONS                                                                     |
    // +-------------------------------------------------------------------------------------+

    /**
     * Ein Genre Objekt wird in der Datenbank abgespeichert.
     * @param genre Ein Genre Objekt.
     */
    public void saveGenre(Genre genre){
        manager.getTransaction().begin();
        try{
            manager.persist(genre);
            manager.getTransaction().commit();
            System.out.println(genre.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Ein Kaufort Objekt wird in der Datenbank abgespeichert.
     * @param kaufort Ein Kaufort Objekt.
     */
    public void saveKaufort(Kaufort kaufort){
        manager.getTransaction().begin();
        try{
            manager.persist(kaufort);
            manager.getTransaction().commit();
            System.out.println(kaufort.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Ein Medium Objekt wird in der Datenbank abgespeichert.
     * @param medium Ein Medium Objekt.
     */
    public void saveMedium(Medium medium){
        manager.getTransaction().begin();
        try{
            manager.persist(medium);
            manager.getTransaction().commit();
            System.out.println(medium.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Ein Sprache Objekt wird in der Datenbank abgespeichert.
     * @param sprache Ein Sprache Objekt.
     */
    public void saveSprache(Sprache sprache){
        manager.getTransaction().begin();
        try{
            manager.persist(sprache);
            manager.getTransaction().commit();
            System.out.println(sprache.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Ein Typ Objekt wird in der Datenbank abgespeichert.
     * @param typ Ein Typ Objekt.
     */
    public void saveTyp(Typ typ){
        manager.getTransaction().begin();
        try{
            manager.persist(typ);
            manager.getTransaction().commit();
            System.out.println(typ.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Ein Verlag Objekt wird in der Datenbank abgespeichert.
     * @param verlag Ein Verlag Objekt.
     */
    public void saveVerlag(Verlag verlag){
        manager.getTransaction().begin();
        try{
            manager.persist(verlag);
            manager.getTransaction().commit();
            System.out.println(verlag.toString() + " saved");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    // +------------------------------------------------------------------------------------------------+
    // | UPDATE DATASETS                                                                                |
    // +------------------------------------------------------------------------------------------------+


    /**
     * Diese Funktion ersetzt/updated einen Datensatz in der Datenbank
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     * @param medium Ein Genre Objekt, dass das in der Datenbank ersezten soll.
     */
    public void updateMedium(int id, Medium medium){
        manager.getTransaction().begin();
        try{
            Medium xMedium = manager.find(Medium.class, id);
            xMedium.setName(medium.getName());
            xMedium.setGenres(medium.getGenres());
            xMedium.setKaufdatum(medium.getKaufdatum());
            xMedium.setKaufort(medium.getKaufort());
            xMedium.setKommentar(medium.getKommentar());
            xMedium.setPreis(medium.getPreis());
            xMedium.setSprache(medium.getSprache());
            xMedium.setTyp(medium.getTyp());
            xMedium.setVerlag(medium.getVerlag());
            manager.getTransaction().commit();
            System.out.println(medium.toString() + " updated");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    // +------------------------------------------------------------------------------------------------+
    // | REMOVE DATASETS                                                                                |
    // +------------------------------------------------------------------------------------------------+

    /**
     * Diese Funtion löscht ein Genre in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeGenre(int id){
        manager.getTransaction().begin();
        try{
            Genre genre = manager.find(Genre.class, id);
            manager.remove(genre);
            manager.getTransaction().commit();
            System.out.println(genre.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funtion löscht einen Kaufort in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeKaufort(int id){
        manager.getTransaction().begin();
        try{
            Kaufort kaufort = manager.find(Kaufort.class, id);
            manager.remove(kaufort);
            manager.getTransaction().commit();
            System.out.println(kaufort.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funtion löscht in Medium in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeMedium(int id){
        manager.getTransaction().begin();
        try{
            Medium medium = manager.find(Medium.class, id);
            manager.remove(medium);
            manager.getTransaction().commit();
            System.out.println(medium.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funtion löscht eine Sprache in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeSprache(int id){
        manager.getTransaction().begin();
        try{
            Sprache sprache = manager.find(Sprache.class, id);
            manager.remove(sprache);
            manager.getTransaction().commit();
            System.out.println(sprache.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funtion löscht einen Typ in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeTyp(int id){
        manager.getTransaction().begin();
        try{
            Typ typ = manager.find(Typ.class, id);
            manager.remove(typ);
            manager.getTransaction().commit();
            System.out.println(typ.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funtion löscht einen Verlag in der Datenbank.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     */
    public void removeVerlag(int id){
        manager.getTransaction().begin();
        try{
            Verlag verlag = manager.find(Verlag.class, id);
            manager.remove(verlag);
            manager.getTransaction().commit();
            System.out.println(verlag.toString() + " removed");
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Diese Funktion überprüft ob ein Medium in der Datenbank existiert.
     * @param id Die Id vom Datansatz der ersetzt werden soll.
     * @return Ein wahr/falsch Wert ob es schon existiert.
     */
    public boolean checkMediumID(int id){
        try{
            Medium xMedium = manager.find(Medium.class, id);
            if(xMedium != null){
                return true;
            }
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Diese Funktion verbindet ein Medium Objekt und ein Genre Objekt in der zwischen Tabelle.
     * @param genre Ein existierendes Genre Objekt
     * @param medium Ein existierendes Medium Objekt.
     */
    public void connect(Genre genre, Medium medium){
        manager.getTransaction().begin();
        try {
            Medium m = manager.find(Medium.class, medium.getMedium_id());
            Genre g = manager.find(Genre.class, genre.getGenre_id());
            m.getGenres().add(g);
            g.getMediumSet().add(m);
            manager.persist(m);
            manager.persist(g);
            manager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }

    /**
     * Diese Funktion prüft ob die Verbindung mit der Datenbank bereits existiert.
     * @return Gibt wahr/falsch zurück ob die Verbindung mit der Datenbank bereits existiert.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Diese Funktion ändert den Status der Verbindung.
     * @param alive Setzt den Wert ob die Verbindung da ist oder nicht.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
