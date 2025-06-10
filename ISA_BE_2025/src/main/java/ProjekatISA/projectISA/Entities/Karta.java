package ProjekatISA.projectISA.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="karta")
@Data
public class Karta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="korisnikID")
    private Integer korisnikID;

    @Column(name="filmID")
    private Integer filmID;

}
