package ProjekatISA.projectISA.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmModel {
    private Integer id;
    //@NonNull
    private String naziv;
    //@NonNull
    private Integer trajanje;

    private String reziser;
}
