package ProjekatISA.projectISA.Models;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class KorisnikKarteModel {
    private Integer id;
    //@NonNull
    private String ime;
    //@NonNull
    private String prezime;
    //@NonNull
    private Integer godine;
    @Email
    private String email;

    private List<KartaModel> karte;
}
