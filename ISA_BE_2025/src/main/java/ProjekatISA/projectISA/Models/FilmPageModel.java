package ProjekatISA.projectISA.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilmPageModel {
    private List<FilmModel> Filmovi;
    private int totalPages;
    private int totalElements;
}
