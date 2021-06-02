package ch.bbw.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Nexterbyby
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "typ")
public class Typ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "typ_id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "typ")
    private Set<Medium> medium;

    public Typ(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Typ(){
        // empty
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Typ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
