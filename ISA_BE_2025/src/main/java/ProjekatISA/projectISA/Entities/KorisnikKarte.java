package ProjekatISA.projectISA.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="korisnik")
@Data
public class KorisnikKarte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ime")
    private String ime;

    @Column(name="prezime")
    private String prezime;

    @Column(name="godine")
    private Integer godine;

    @Column(name="email")
    private String email;

    @Column(name="lozinka")
    private String lozinka;

    @OneToMany(mappedBy = "korisnikID")
    private List<Karta> karte;
}
