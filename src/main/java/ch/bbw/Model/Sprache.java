package ch.bbw.Model;

import javax.persistence.*;


/**
 * @author Ricedefender
 * @version 0.0.1
 * @since 0.0.1
 */


@Entity
@Table(name = "sprache")
@NamedQuery(name ="Sprache.findAll", query = "Select e FROM Sprache e")
public class Sprache {
    @Id
    @Column(name = "sprache_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sprache_id;

    @Column(name = "name")
    private String name;

    /**
     * Lerrer Constructor um Sprache zu erstellen
     */
    public Sprache() {
    }

    /**
     * Constructor um die Sprache mit id zu erstellen
     * @param sprache_id
     * @param name
     */
    public Sprache(int sprache_id, String name) {
        this.sprache_id = sprache_id;
        this.name = name;
    }

    /**
     * Constructor um den Namen der Sprache zu setzen
     * @param name
     */
    public Sprache(String name) {
        this.name = name;
    }

    /**
     * ToString Methode um den Namen von der Sprache zu erhalten
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    /*
    public int getSprache_id() {
        return sprache_id;
    }

    public void setSprache_id(int sprache_id) {
        this.sprache_id = sprache_id;
    }
     */

    /**
     * Getter Methode um den Namen zu erhalten
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter Methode um den Namen zu setzen
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}

