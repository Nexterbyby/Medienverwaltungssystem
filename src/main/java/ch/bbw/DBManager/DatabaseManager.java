package ch.bbw.DBManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    }

    public void startup(){
        this.emFactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
        this.manager = emFactory.createEntityManager();
    }

    public void closeup(){
        this.emFactory.close();
        this.manager.close();
    }
}
