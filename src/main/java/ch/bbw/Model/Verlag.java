package ch.bbw.Model;


import javax.persistence.*;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "verlag")
@NamedQuery(name ="Verlag.findAll", query = "Select e FROM Verlag e")
public class Verlag {

    @Id
    @Column(name = "verlag_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int verlag_id;

    @Column(name = "name", nullable = false)
    private String name;

    public Verlag() {
    }

    public Verlag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //Getter and Setter

    public int getVerlag_id() {
        return verlag_id;
    }

    public void setVerlag_id(int verlag_id) {
        this.verlag_id = verlag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
