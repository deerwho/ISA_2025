package ProjekatISA.projectISA.Mappers;

import ProjekatISA.projectISA.Entities.KorisnikKarte;
import ProjekatISA.projectISA.Models.KorisnikKarteModel;

import java.util.ArrayList;
import java.util.List;

public class KorisnikKarteMapper {

    public static KorisnikKarteModel toModel(KorisnikKarte entity){
        return KorisnikKarteModel.builder()
                .id(entity.getId())
                .ime(entity.getIme())
                .prezime(entity.getPrezime())
                .godine(entity.getGodine())
                .email(entity.getEmail())
                .karte(KartaMapper.toModelList(entity.getKarte())).build();

    }
    public static List<KorisnikKarteModel> toModelList(List<KorisnikKarte> entities){
        var list = new ArrayList<KorisnikKarteModel>();
        for(KorisnikKarte entity : entities){
            list.add(toModel(entity));
        }
        return list;

    }
}
