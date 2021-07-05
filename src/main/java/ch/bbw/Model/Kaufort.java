package ch.bbw.Model;

import javax.persistence.*;

/**
 * @author Nexterbyby
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "kaufort")
public class Kaufort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kaufort_id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * Constructor um den id und Namen zu setzen
     * @param id
     * @param name
     */
    public Kaufort(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Leerer Constructor um einen Kaufort zu erstellen
     */
    public Kaufort(){
        //empty
    }

    /**
     * Constructor um den Namen zu setzen
     * @param name
     */
    public Kaufort(String name) {
        this.name = name;
    }

    /**
     * ToString Methode um den Namen des Kaufortes zu bekommen
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Getter Methode um die id vom Kaufort zu bekommen
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter Methode um den id vom Kaufort zu ersetzen
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter Methode um den namen vom Kaufort zu bekommen
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter Methode um den namen vom Kaufort zu ersetzen
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
