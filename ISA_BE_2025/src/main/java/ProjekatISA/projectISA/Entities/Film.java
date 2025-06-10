package ProjekatISA.projectISA.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="film")
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="naziv")
    private String naziv;

    @Column(name="trajanje")
    private Integer trajanje;

    @Column(name="reziser")
    private String reziser;

    @OneToMany(mappedBy = "filmID")
    private List<Karta> karte;

    @ManyToMany(mappedBy = "filmovi")
    @JsonBackReference
    private List<Korisnik> korisnici;

}
