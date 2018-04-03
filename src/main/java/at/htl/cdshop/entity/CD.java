package at.htl.cdshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "band_id")
    @JsonIgnore
    private Band band;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "cd",
            cascade = CascadeType.ALL)
    private List<Track> tracks = new LinkedList<>();

    public CD() {
    }

    public CD(String title, Band band) {
        this.title = title;
        this.band = band;
        this.tracks = tracks;
        this.band.getCds().add(this);
    }

    public void addTrack(Track track) {
        tracks.add(track);
        track.setCd(this);
    }

    public void removeTrack (Track track) {
        tracks.remove(track);
        track.setCd(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
