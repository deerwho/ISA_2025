package ProjekatISA.projectISA.Mappers;

import ProjekatISA.projectISA.Entities.Karta;
import ProjekatISA.projectISA.Entities.Korisnik;
import ProjekatISA.projectISA.Models.KartaModel;
import ProjekatISA.projectISA.Models.KorisnikModel;
import ProjekatISA.projectISA.Models.KorisnikPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class KartaMapper {
    public static KartaModel toModel(Karta entity){
        return KartaModel.builder()
                .id(entity.getId())
                .korisnikID(entity.getKorisnikID())
                .filmID(entity.getFilmID()).build();

    }

    public static List<KartaModel> toModelList(List<Karta> entities){
        var list = new ArrayList<KartaModel>();
        for(Karta entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }




}
