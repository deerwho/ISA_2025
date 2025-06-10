package ProjekatISA.projectISA.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KartaModel {
    private Integer id;
    private Integer korisnikID;
    private Integer filmID;
}
