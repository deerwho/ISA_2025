package ProjekatISA.projectISA.Mappers;

import ProjekatISA.projectISA.Entities.Korisnik;
import ProjekatISA.projectISA.Entities.KorisnikKarte;
import ProjekatISA.projectISA.Models.KorisnikKarteModel;
import ProjekatISA.projectISA.Models.KorisnikModel;
import ProjekatISA.projectISA.Models.KorisnikPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class KorisnikMapper {
    public static KorisnikModel toModel(Korisnik entity){
       return KorisnikModel.builder()
                //.id(entity.getId())
                .ime(entity.getIme())
                .prezime(entity.getPrezime())
                .godine(entity.getGodine())
                .email(entity.getEmail())
               .lozinka(entity.getLozinka()).build();

    }

    public static Korisnik toEntity(KorisnikModel model){
        Korisnik korisnik=new Korisnik();
        korisnik.setId(model.getId());
        korisnik.setIme(model.getIme());
        korisnik.setPrezime(model.getPrezime());
        korisnik.setGodine(model.getGodine());
        korisnik.setEmail(model.getEmail());
        korisnik.setLozinka(model.getLozinka());

        return korisnik;
    }

    public static List<KorisnikModel> toModelList(List<Korisnik> entities){
        var list = new ArrayList<KorisnikModel>();
        for(Korisnik entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }

    public static KorisnikPageModel toModelPagedList(Page<Korisnik> pageEntity){
        return KorisnikPageModel.builder()
                .Korisnici(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements((int) pageEntity.getTotalElements()).build();

    }

}
