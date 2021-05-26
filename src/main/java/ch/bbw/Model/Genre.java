package ch.bbw.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
@NamedQuery(name ="Genre.findAll", query = "Select e FROM Genre e")
public class Genre {
    @Id
    @Column(name = "genre_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int genre_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "medium")
    private Set<Medium> mediumSet = new HashSet<>();

    public Genre() {
    }

    public Genre(int genre_id, String name, Set<Medium> mediumSet) {
        this.genre_id = genre_id;
        this.name = name;
        this.mediumSet = mediumSet;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                ", mediumSet=" + mediumSet +
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

    public Set<Medium> getMediumSet() {
        return mediumSet;
    }

    public void setMediumSet(Set<Medium> mediumSet) {
        this.mediumSet = mediumSet;
    }
}
