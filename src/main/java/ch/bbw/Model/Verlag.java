package ch.bbw.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "verlag")
@NamedQuery(name ="Verlag.findAll", query = "Select e FROM Verlag e")
public class Verlag {

    @Id
    @Column(name = "verlag_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int verlag_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "verlag")
    private Set<Medium> medium;

    public Verlag() {
    }

    public Verlag(int verlag_id, String name) {
        this.verlag_id = verlag_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Verlag{" +
                "verlag_id=" + verlag_id +
                ", name='" + name + '\'' +
                '}';
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
