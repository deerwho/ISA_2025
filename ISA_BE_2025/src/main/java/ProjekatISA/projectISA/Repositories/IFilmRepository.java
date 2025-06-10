package ProjekatISA.projectISA.Repositories;

import ProjekatISA.projectISA.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmRepository extends JpaRepository<Film, Integer> {}
