package ch.bbw.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(int genre_id, String name, List<Medium> mediumSet) {
        this.genre_id = genre_id;
        this.name = name;
        this.mediumSet = mediumSet;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name +
                '}';
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medium> getMediumSet() {
        return mediumSet;
    }

    public void setMediumSet(List<Medium> mediumSet) {
        this.mediumSet = mediumSet;
    }
}
