package ch.bbw.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "genre")
@NamedQuery(name ="Genre.findAll", query = "Select e FROM Genre e")
public class Genre {
    @Id
    @Column(name = "genre_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "medium_genre",
            joinColumns = {@JoinColumn(name = "genre_idfs")},
            inverseJoinColumns = {@JoinColumn(name = "medium_idfs")}
    )
    private List<Medium> mediumSet;

    /**
     * Leerer Constructor um Genre zu erstellen
     */
    public Genre() {
    }

    /**
     * Constructor um den Namen zu setzen
     * @param name
     */
    public Genre(String name) {
        this.name = name;
    }

    public Genre(int genre_id, String name, List<Medium> mediumSet) {
        this.genre_id = genre_id;
        this.name = name;
        this.mediumSet = mediumSet;
    }

    /**
     * ToString Methode um den Namen der Genre zu erhalten
     * @return String um den Namen der Genre zu erhalten
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Getter Methode um den id einer Genre zu erhalten
     * @return id von einem Genre
     */
    public int getGenre_id() {
        return genre_id;
    }

    /*
    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
     */

    /**
     * Getter Methode um den Namen der Genre zu erhalten
     * @return name von einem Genre
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

    /**
     * Getter Methode um die Medium Liste zu erhalten
     * @return List Medium
     */
    public List<Medium> getMediumSet() {
        return mediumSet;
    }

}
