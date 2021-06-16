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

    public void startup(){
        try{
            this.emFactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
            this.manager = emFactory.createEntityManager();
            this.alive = true;
        }catch (Exception e){
            System.out.println("startup() failed");
        }
    }

    public void closeup(){
        this.emFactory.close();
        this.manager.close();
    }

    // +-------------------------------------------------------------------+
    // | READ OPERATIONS                                                   |
    // +-------------------------------------------------------------------+

    public List<Genre> getAllGenres(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Genre> genres = manager.createQuery("SELECT o FROM Genre o").getResultList();
        manager.getTransaction().commit();
        return genres;
    }

    public List<Kaufort> getAllKauforte(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Kaufort> kauforte = manager.createQuery("SELECT o FROM Kaufort o").getResultList();
        manager.getTransaction().commit();
        return kauforte;
    }

    public List<Medium> getAllMedia(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Medium> medien = manager.createQuery("SELECT o FROM Medium o").getResultList();
        manager.getTransaction().commit();
        return medien;
    }

    public List<Sprache> getAllSprachen(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Sprache> sprachen = manager.createQuery("SELECT o FROM Sprache o").getResultList();
        manager.getTransaction().commit();
        return sprachen;
    }

    public List<Typ> getAllTypen(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Typ> typen = manager.createQuery("SELECT o FROM Typ o").getResultList();
        manager.getTransaction().commit();
        return typen;
    }

    public List<Verlag> getAllVerlaege(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Verlag> verlaege = manager.createQuery("SELECT o FROM Verlag o").getResultList();
        manager.getTransaction().commit();
        return verlaege;
    }


    // +-------------------------------------------------------------------------------------+
    // | SAVE OPERATIONS                                                                     |
    // +-------------------------------------------------------------------------------------+

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


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
