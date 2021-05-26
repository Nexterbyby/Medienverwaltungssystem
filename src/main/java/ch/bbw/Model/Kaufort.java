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

    public Kaufort(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kaufort(){
        //empty
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
}
