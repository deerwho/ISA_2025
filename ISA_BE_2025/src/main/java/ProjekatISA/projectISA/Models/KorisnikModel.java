package ProjekatISA.projectISA.Models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class KorisnikModel {
    private Integer id;
    //@NonNull
    private String ime;
    //@NonNull
    private String prezime;
    //@NonNull
    private Integer godine;
    @Email
    private String email;

    private String lozinka;
}
