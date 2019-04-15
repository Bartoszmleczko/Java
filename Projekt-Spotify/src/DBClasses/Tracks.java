/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBClasses;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bartosz
 */
@Entity
@Table(name = "Tracks")
public class Tracks implements Serializable {
   
    
    private static final long serialVersionUID = -300030L;
    @Column(name = "track_id", unique = true)
    @Id
    @GeneratedValue
    private int track_id;
    @Column(name = "track_title")
    private String track_title;
        @Column(name = "track_source")
    private String track_source;

    public String getTrack_source() {
        return track_source;
    }

    public void setTrack_source(String track_source) {
        this.track_source = track_source;
    }

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Artists artist;

    public Artists getArt() {
        return artist;
    }

    public void setArt(Artists art) {
        this.artist = art;
    }

    public Albums getAlb() {
        return alb;
    }

    public void setAlb(Albums alb) {
        this.alb = alb;
    }

    public List<Playlists> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlists> playlists) {
        this.playlists = playlists;
    }


    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }
    @ManyToOne
    @JoinColumn(name = "alb_id")
    private Albums alb;
    
    @ManyToMany(mappedBy = "tracks")
    private List<Playlists> playlists;

    public Tracks() {
    }

    public Tracks(String track_title) {
        this.track_title = track_title;
    }

    public String getTrack_title() {
        return track_title;
    }

    public void setTrack_title(String track_title) {
        this.track_title = track_title;
    }

    @Override
    public String toString() {
        return   track_title;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

}
