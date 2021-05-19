package ch.bbw.db_tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="medium")
public class Medium implements Serializable {

    @Id
    @Column(name = "medium_id", unique = true)
    private int id;

    @Column(name="name")
    public String name;

    @Column(name="price")
    public double price;

    public Medium(){
    }

}
