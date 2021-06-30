package ch.bbw.Model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Nghia Dao
 *
 */


@Entity
@Table(name = "medium")
@NamedQuery(name ="Medium.findAll", query = "Select e FROM Medium e")
public class Medium {

    @Id
    @Column(name = "medium_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medium_id;

    @Column(name = "kaufdatum")
    private Timestamp kaufdatum;

    @Column(name = "name")
    private String name;

    @Column(name = "preis")
    private Double preis;

    @ManyToOne
    @JoinColumn(name = "sprache_idfs")
    private Sprache sprache;

    @ManyToOne
    @JoinColumn (name = "verlag_idfs")
    private Verlag verlag;

    @ManyToOne
    @JoinColumn (name = "kaufort_idfs")
    private Kaufort kaufort;

    @ManyToOne
    @JoinColumn (name = "typ_idfs")
    private Typ typ;

    @Column(name = "kommentar")
    private String kommentar;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "mediumSet")
    private List<Genre> genres;





    public Medium(){
    }

    public Medium (int medium_id,  Timestamp kaufdatum, Double preis, String kommentar){
        super();
        this.kaufdatum = kaufdatum;
        this.preis = preis;
        this.kommentar = kommentar;
    }

    public Medium (  Timestamp kaufdatum, Double preis, String kommentar){
        this.kaufdatum = kaufdatum;
        this.preis = preis;
        this.kommentar = kommentar;
    }

    public Medium(Timestamp kaufdatum, String name, Double preis, Sprache sprache, Verlag verlag, Kaufort kaufort, Typ typ, String kommentar) {
        this.kaufdatum = kaufdatum;
        this.name = name;
        this.preis = preis;
        this.sprache = sprache;
        this.verlag = verlag;
        this.kaufort = kaufort;
        this.typ = typ;
        this.kommentar = kommentar;
    }

    public Medium(String name, Double preis, Sprache sprache, Verlag verlag, Kaufort kaufort, Typ typ, String kommentar) {
        this.name = name;
        this.preis = preis;
        this.sprache = sprache;
        this.verlag = verlag;
        this.kaufort = kaufort;
        this.typ = typ;
        this.kommentar = kommentar;
    }


    //Getter and Setter

    public int getMedium_id() {
        return medium_id;
    }

    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }

    public Timestamp getKaufdatum() {
        return kaufdatum;
    }

    public void setKaufdatum(Timestamp kaufdatum) {
        this.kaufdatum = kaufdatum;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Sprache getSprache() {
        return sprache;
    }

    public void setSprache(Sprache sprache) {
        this.sprache = sprache;
    }

    public Verlag getVerlag() {
        return verlag;
    }

    public void setVerlag(Verlag verlag) {
        this.verlag = verlag;
    }

    public Kaufort getKaufort() {
        return kaufort;
    }

    public void setKaufort(Kaufort kaufort) {
        this.kaufort = kaufort;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
