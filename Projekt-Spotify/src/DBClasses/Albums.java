/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBClasses;

/**
 *
 * @author Bartosz
 */
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Albums")
public class Albums implements Serializable {

    private static final long serialVersionUID = -300030L;
    @Column(name = "alb_id", unique = true)
    @Id
    @GeneratedValue
    private int alb_id;
    @Column(name = "alb_title")
    private String alb_title;
    @Column(name = "rel_year")
    private int rel_year;
    @ManyToOne
    @JoinColumn(name= "art_id")
    private Artists artist;
    @OneToMany(mappedBy = "alb")
    private List<Tracks> tracks;

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }
    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }
    public Albums() {
    }

    public Albums(String alb_title, int rel_year) {
        this.alb_title = alb_title;
        this.rel_year = rel_year;
    }

    public int getAlb_id() {
        return alb_id;
    }

    public String getAlb_title() {
        return alb_title;
    }

    public void setAlb_id(int alb_id) {
        this.alb_id = alb_id;
    }

    public void setAlb_title(String alb_title) {
        this.alb_title = alb_title;
    }

    public void setRel_year(int rel_year) {
        this.rel_year = rel_year;
    }

    @Override
    public String toString() {
        return "Albums{" + "alb_id=" + alb_id + ", alb_title=" + alb_title + ", rel_year=" + rel_year + '}';
    }

}
