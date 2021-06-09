package ch.bbw.DBManager;

import ch.bbw.Model.Genre;

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
public class DatabaseManager {
    private EntityManagerFactory emFactory;
    private EntityManager manager;

    public DatabaseManager(){
        // Nothing...
        System.out.println("Constructor called");
    }

    public void startup(){
        System.out.println("Startup called");
        this.emFactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        if(emFactory == null) System.out.println("emFactory is null");

        try{
            this.manager = emFactory.createEntityManager();
        }catch (Exception e){
            System.out.println("Manager Failed");
            e.getCause();
            System.out.println(e.toString());
        }
        System.out.println("Startup finished");
    }

    public void closeup(){
        this.emFactory.close();
        this.manager.close();
    }

    // +------------------------+
    // | READ OPERATIONS        |
    // +------------------------+

    public void printGenres(){
        manager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Genre> genres = manager.createQuery("SELECT o FROM Genre o").getResultList();
        manager.getTransaction().commit();
        if(genres != null){
            genres.forEach(System.out::println);
        }else{
            System.out.println("The genre list is empty");
        }
    }


}
