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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bartosz
 */
@Entity
@Table(name = "Artists")

public class Artists implements Serializable {

    private static final long serialVersionUID = -300025L;

    @Column(name = "art_id", unique = true)
    @Id 
    @GeneratedValue
    private int art_id;

    @Column(name = "art_name")
    private String art_name;
    
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }
    @OneToMany(mappedBy = "artist")
    private List<Albums> albums;
    @OneToMany(mappedBy = "artist")
    private List<Tracks> tracks;
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Albums> albums) {
        this.albums = albums;
    }

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }

    public Artists() {
    }

    public Artists(String art_name) {

        this.art_name = art_name;
    }

    public Artists(String art_name, String description) {
        this.art_name = art_name;
        this.description = description;
    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    @Override
    public String toString() {
        return art_name ;
    }

}
