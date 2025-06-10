package ProjekatISA.projectISA.Models;

import ProjekatISA.projectISA.Entities.Korisnik;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class KorisnikPageModel {
    private List<KorisnikModel> Korisnici;
    private int totalPages;
    private int totalElements;
}
