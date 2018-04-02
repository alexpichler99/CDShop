package at.htl.cdshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = "Band.findAll", query = "select b from Band b")
)
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Digits(integer = 4, fraction = 0)
    private int yearFounded;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CD> cds = new LinkedList<>();

    public Band() {
    }

    public Band(String name, int yearFounded) {
        this.name = name;
        this.yearFounded = yearFounded;
    }

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
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

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }
}
