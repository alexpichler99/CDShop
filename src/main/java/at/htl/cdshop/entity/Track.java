package at.htl.cdshop.entity;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(name = "Track.findByCD", query = "select track from Track track " +
                "join fetch track.cd where track.cd = :CD")
)
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private CD cd;

    public Track() {
    }

    public Track(String name, CD cd) {
        this.name = name;
        this.cd = cd;
        this.cd.getTracks().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }
}
