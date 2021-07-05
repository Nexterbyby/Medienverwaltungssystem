package ch.bbw.Model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RiceDefender
 * @version 0.0.1
 * @since 0.0.1
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


    /**
     * Leerer Constructor um Medium zu erstellen
     */
    public Medium(){
    }

    /**
     * Constructor um id, kaufdatum, preis und kommentar zu setzen
     * @param medium_id
     * @param kaufdatum
     * @param preis
     * @param kommentar
     */
    public Medium (int medium_id,  Timestamp kaufdatum, Double preis, String kommentar){
        super();
        this.kaufdatum = kaufdatum;
        this.preis = preis;
        this.kommentar = kommentar;
    }

    /**
     * Constructor um kaufdatum, preis und kommentar zu setzen
     * @param kaufdatum
     * @param preis
     * @param kommentar
     */
    public Medium (  Timestamp kaufdatum, Double preis, String kommentar){
        this.kaufdatum = kaufdatum;
        this.preis = preis;
        this.kommentar = kommentar;
    }

    /**
     * Constructor um alles ausser den id zu setzen
     * @param kaufdatum
     * @param name
     * @param preis
     * @param sprache
     * @param verlag
     * @param kaufort
     * @param typ
     * @param kommentar
     */
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

    /**
     * Constructor um alles ausser id und die Zeit zu setzen
     * @param name
     * @param preis
     * @param sprache
     * @param verlag
     * @param kaufort
     * @param typ
     * @param kommentar
     */
    public Medium(String name, Double preis, Sprache sprache, Verlag verlag, Kaufort kaufort, Typ typ, String kommentar) {
        this.name = name;
        this.preis = preis;
        this.sprache = sprache;
        this.verlag = verlag;
        this.kaufort = kaufort;
        this.typ = typ;
        this.kommentar = kommentar;
    }

    /**
     * Methode um den Namen des Mediums zu bekommen
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    //Getter and Setter

    /**
     * Getter Methode um den id des Mediums zu erhalten
     * @return id
     */
    public int getMedium_id() {
        return medium_id;
    }

    /*
    public void setMedium_id(int medium_id) {
        this.medium_id = medium_id;
    }
     */

    /**
     * Getter Methode um den Kaufdatum zu erhalten
     * @return kaufdatum
     */
    public Timestamp getKaufdatum() {
        return kaufdatum;
    }

    /**
     * Setter Methode um den Timestamp zu setzen
     * @param kaufdatum
     */
    public void setKaufdatum(Timestamp kaufdatum) {
        this.kaufdatum = kaufdatum;
    }

    /**
     * Getter Methode um den Preis zu erhalten
     * @return preis
     */
    public Double getPreis() {
        return preis;
    }

    /**
     * Setter methode um den Preis zu setzen
     * @param preis
     */
    public void setPreis(Double preis) {
        this.preis = preis;
    }

    /**
     * Getter Methode um die Sprache zu erhalten
     * @return sprache
     */
    public Sprache getSprache() {
        return sprache;
    }

    /**
     * Setter Methode um Sprache zu setzen
     * @param sprache
     */
    public void setSprache(Sprache sprache) {
        this.sprache = sprache;
    }

    /**
     * Getter Methode um den Verlag zu erhalten
     * @return verlag
     */
    public Verlag getVerlag() {
        return verlag;
    }

    /**
     * Setter Methode um den Verlag zu setzen
     * @param verlag
     */
    public void setVerlag(Verlag verlag) {
        this.verlag = verlag;
    }

    /**
     * Getter Methode um den Kaufort zu erhalten
     * @return kaufort
     */
    public Kaufort getKaufort() {
        return kaufort;
    }

    /**
     * Setter Methode um den Kaufort zu setzen
     * @param kaufort
     */
    public void setKaufort(Kaufort kaufort) {
        this.kaufort = kaufort;
    }

    /**
     * Getter Methode um den Typ zu erhalten
     * @return typ
     */
    public Typ getTyp() {
        return typ;
    }

    /**
     * Setter Methode um den Typ zu setzen
     * @param typ
     */
    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    /**
     * Getter Methode um den Kommentar zu erhalten
     * @return kommentar
     */
    public String getKommentar() {
        return kommentar;
    }

    /**
     * Setter Methode um den Kommentar zu setzen
     * @param kommentar
     */
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    /**
     * Getter Methode um die Genre Liste zu erhalten
     * @return
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * Setter Methode um die Genre Liste zu setzen
     * @param genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Getter Methode um den Namen zu erhalten.
     * @return name
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
}
