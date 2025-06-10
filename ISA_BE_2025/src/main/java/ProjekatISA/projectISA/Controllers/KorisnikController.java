package ProjekatISA.projectISA.Controllers;

import ProjekatISA.projectISA.Entities.Korisnik;
import ProjekatISA.projectISA.Mappers.KorisnikKarteMapper;
import ProjekatISA.projectISA.Mappers.KorisnikMapper;
import ProjekatISA.projectISA.Models.KorisnikKarteModel;
import ProjekatISA.projectISA.Models.KorisnikModel;
import ProjekatISA.projectISA.Models.KorisnikPageModel;
import ProjekatISA.projectISA.Repositories.IKorisnikKarteRepository;
import ProjekatISA.projectISA.Repositories.IKorisnikRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ProjekatISA.projectISA.Mappers.KorisnikMapper.toModelList;

@RestController
@RequestMapping("korisnik")
@RequiredArgsConstructor
public class KorisnikController {
    private final IKorisnikKarteRepository korisnikKarteRepository;
    private final IKorisnikRepository korisnikRepository;

    /*public KorisnikController(IKorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }*/ //ne mora zbog @requiredArgsConstructor


    ////*******************   GET metode   *******************////

    @CrossOrigin("*")
    @GetMapping("vrati-sve-korisnike")
    public List<Korisnik> vratiSveKorisnike() {
        var result = korisnikRepository.findAll();
        //var resultTest=korisnikRepository.findByEmail("vojin@singimail.rs");
        return result;
    }

    @CrossOrigin("*")//Ovo koristimo da ne citamo iz baze direkt na fe
    @GetMapping("vrati-sve-korisnikeModel")
    public List<KorisnikModel> vratiSveKorisnikeModel() {
        var test = korisnikRepository.findAll();
        var test2 = korisnikKarteRepository.findAll();
        var test3 = KorisnikKarteMapper.toModelList(test2);
        return toModelList(korisnikRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("vrati-sve-korisnikeKarteModel")
    public List<KorisnikKarteModel> vratiSveKorisnikeKarteModel() {
        return KorisnikKarteMapper.toModelList(korisnikKarteRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("vrati-sve-korisnikePage")
    public KorisnikPageModel vratiSveKorisnikePage(Integer pageNumber, Integer pageSize) {
        return KorisnikMapper.toModelPagedList(korisnikRepository.findAll(PageRequest.of(pageNumber, pageSize)));
    }

    ////*******************   POST metode   *******************////

    @CrossOrigin("*")
    @PostMapping("kreiraj-korisnika")
    public ResponseEntity<?> kreirajKorisnika(@RequestBody @Valid KorisnikModel korisnikModel, BindingResult result)
    {
        if (result.hasErrors())
        {
            //return ResponseEntity.badRequest().body(result);
            return new ResponseEntity<>("Neuspesno registrovanje korisnika.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        var entity=KorisnikMapper.toEntity(korisnikModel);
        korisnikRepository.save(entity);

        return new ResponseEntity<KorisnikModel>(korisnikModel, HttpStatus.CREATED);
    }

    ////*******************   PUT metode   *******************////

    @CrossOrigin("*")
    @PutMapping("izmeni-korisnika")
    public ResponseEntity<?> izmeniKorisnika(@RequestBody @Valid KorisnikModel korisnikModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neispravni podaci za izmenu korisnika.", HttpStatus.BAD_REQUEST);
        }

        if (korisnikModel.getId() == null) {
            return new ResponseEntity<>("ID korisnika nije prosleđen.", HttpStatus.BAD_REQUEST);
        }

        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(korisnikModel.getId());

        if (korisnikOptional.isEmpty()) {
            return new ResponseEntity<>("Korisnik nije pronađen.", HttpStatus.NOT_FOUND);
        }

        Korisnik korisnikZaIzmenu = korisnikOptional.get();

        korisnikZaIzmenu.setIme(korisnikModel.getIme());
        korisnikZaIzmenu.setPrezime(korisnikModel.getPrezime());
        korisnikZaIzmenu.setGodine(korisnikModel.getGodine());
        korisnikZaIzmenu.setEmail(korisnikModel.getEmail());
        korisnikZaIzmenu.setLozinka(korisnikModel.getLozinka());

        korisnikRepository.save(korisnikZaIzmenu);

        return new ResponseEntity<>("Korisnik uspešno izmenjen.", HttpStatus.OK);
    }


    ////*******************   DELETE metoda   *****************////

    @CrossOrigin("*")
    @DeleteMapping("obrisi-korisnika")
    public ResponseEntity<?> obrisiKorisnika(@RequestBody Map<String, Integer> body) {
        Integer id = body.get("id");

        if (id == null) {
            return new ResponseEntity<>("ID korisnika nije prosleđen.", HttpStatus.BAD_REQUEST);
        }

        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);

        if (korisnikOptional.isPresent()) {
            korisnikRepository.deleteById(id);
            return new ResponseEntity<>("Korisnik uspešno obrisan.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Korisnik nije pronađen.", HttpStatus.NOT_FOUND);
        }
    }


    ////*******************   ManyToMany veza Korisnik-Film   *******************////

    @CrossOrigin("*")
    @GetMapping("vrati-sve-korisnikeFilmovi")
    public List<Korisnik> vratiSveKorisnikeFilmovi() {
        var result = korisnikRepository.findAll();
        return result;
    }

}
