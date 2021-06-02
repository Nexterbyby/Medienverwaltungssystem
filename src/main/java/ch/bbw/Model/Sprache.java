package ch.bbw.Model;

import javax.persistence.*;
import java.util.Set;


/**
 * @Author Nghia Dao
 *
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

    @OneToMany(mappedBy = "sprache")
    private Set<Medium> medium;

    public Sprache() {
    }

    public Sprache(int sprache_id, String name) {
        this.sprache_id = sprache_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sprache{" +
                "sprache_id=" + sprache_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSprache_id() {
        return sprache_id;
    }

    public void setSprache_id(int sprache_id) {
        this.sprache_id = sprache_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

