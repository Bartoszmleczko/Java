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
@Table(name = "Playlists")
public class Playlists implements Serializable {

    private static final long serialVersionUID = -300030L;
    @Column(name = "play_id", unique = true)
    @Id
    @GeneratedValue
    private int play_id;
    @Column(name = "play_name")
    private String play_name;

    @ManyToMany
    @JoinTable(
            name = "Tracks_Playlists",
            joinColumns = {
                @JoinColumn(name = "play_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "track_id")}
    )
    private List<Tracks> tracks;

    @Override
    public String toString() {
        return "Playlists{" + "play_id=" + play_id + ", play_name=" + play_name + ", tracks=" + tracks + '}';
    }

    public Playlists(String play_name) {
        this.play_name = play_name;
    }

    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }
    
    public List<Tracks> getTracks() {
        return tracks;
    }


    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }

    public Playlists() {
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

}
