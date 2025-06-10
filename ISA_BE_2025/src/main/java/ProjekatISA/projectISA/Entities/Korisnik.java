package ProjekatISA.projectISA.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.List;

@Entity
@Table(name="korisnik")
@Data

public class Korisnik {
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="korisnicifilmovi",
        joinColumns = @JoinColumn(name="korisnikID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="filmID", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Film> filmovi;

}
