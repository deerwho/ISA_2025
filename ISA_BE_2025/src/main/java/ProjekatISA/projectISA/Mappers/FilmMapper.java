package ProjekatISA.projectISA.Mappers;

import ProjekatISA.projectISA.Entities.Film;
import ProjekatISA.projectISA.Models.FilmModel;
import ProjekatISA.projectISA.Models.FilmPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class FilmMapper {
    public static FilmModel toModel(Film entity){
        return FilmModel.builder()
                //.id(entity.getId())
                .naziv(entity.getNaziv())
                .trajanje(entity.getTrajanje())
                .reziser(entity.getReziser())
                .build();

    }

    public static Film toEntity(FilmModel model){
        Film film=new Film();
        film.setId(model.getId());
        film.setNaziv(model.getNaziv());
        film.setTrajanje(model.getTrajanje());
        film.setReziser(model.getReziser());

        return film;
    }

    public static List<FilmModel> toModelList(List<Film> entities){
        var list = new ArrayList<FilmModel>();
        for(Film entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }

    public static FilmPageModel toModelPagedList(Page<Film> pageEntity){
        return FilmPageModel.builder()
                .Filmovi(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements((int) pageEntity.getTotalElements()).build();

    }

}
