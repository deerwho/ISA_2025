package ProjekatISA.projectISA.Controllers;

import ProjekatISA.projectISA.Entities.Film;
import ProjekatISA.projectISA.Mappers.FilmMapper;
import ProjekatISA.projectISA.Mappers.KorisnikMapper;
import ProjekatISA.projectISA.Models.FilmPageModel;
import ProjekatISA.projectISA.Models.KorisnikModel;
import ProjekatISA.projectISA.Models.KorisnikPageModel;
import ProjekatISA.projectISA.Repositories.IFilmRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ProjekatISA.projectISA.Models.FilmModel;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("film")
@RequiredArgsConstructor
public class FilmController {
    private final IFilmRepository filmRepository;

    ////*******************   GET metode   *******************////

    @CrossOrigin("*")
    @GetMapping("vrati-sve-filmove")
    public List<Film> vratiSveFilmove() {
        var result = filmRepository.findAll();
        return result;
    }

    @CrossOrigin("*")
    @GetMapping("vrati-sve-filmoveModel")
    public List<FilmModel> vratiSveFilmoveModel() {
        var test = filmRepository.findAll();
        return FilmMapper.toModelList(filmRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("vrati-sve-filmovePage")
    public FilmPageModel vratiSveFilmovePage(Integer pageNumber, Integer pageSize) {
        return FilmMapper.toModelPagedList(filmRepository.findAll(PageRequest.of(pageNumber, pageSize)));
    }

    ////*******************   POST metode   *******************////

    @CrossOrigin("*")
    @PostMapping("kreiraj-film")
    public ResponseEntity<?> kreirajFilm(@RequestBody @Valid FilmModel filmModel, BindingResult result)
    {
        if (result.hasErrors())
        {
            return new ResponseEntity<>("Neuspesno kreiranje filma.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        var entity=FilmMapper.toEntity(filmModel);
        filmRepository.save(entity);

        return new ResponseEntity<FilmModel>(filmModel, HttpStatus.CREATED);
    }


    ////*******************   PUT metode   *******************////

    @CrossOrigin("*")
    @PutMapping("izmeni-film")
    public ResponseEntity<?> izmeniKFilm(@RequestBody @Valid FilmModel filmModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Neispravni podaci za izmenu filma.", HttpStatus.BAD_REQUEST);
        }

        if (filmModel.getId() == null) {
            return new ResponseEntity<>("ID filma nije prosleđen.", HttpStatus.BAD_REQUEST);
        }

        Optional<Film> filmOptional = filmRepository.findById(filmModel.getId());

        if (filmOptional.isEmpty()) {
            return new ResponseEntity<>("Film nije pronađen.", HttpStatus.NOT_FOUND);
        }

        Film filmZaIzmenu = filmOptional.get();

        filmZaIzmenu.setNaziv(filmModel.getNaziv());
        filmZaIzmenu.setTrajanje(filmModel.getTrajanje());
        filmZaIzmenu.setReziser(filmModel.getReziser());;

        filmRepository.save(filmZaIzmenu);

        return new ResponseEntity<>("Film uspešno izmenjen.", HttpStatus.OK);
    }


    ////*******************   DELETE metoda   *******************////

    @CrossOrigin("*")
    @DeleteMapping("obrisi-film")
    public ResponseEntity<?> obrisiFilm(@RequestBody Map<String, Integer> body) {
        Integer id = body.get("id");

        if (id == null) {
            return new ResponseEntity<>("ID filmma nije prosleđen.", HttpStatus.BAD_REQUEST);
        }

        Optional<Film> filmOptional = filmRepository.findById(id);

        if (filmOptional.isPresent()) {
            filmRepository.deleteById(id);
            return new ResponseEntity<>("Film uspešno obrisan.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fiilm nije pronađen.", HttpStatus.NOT_FOUND);
        }
    }



}
