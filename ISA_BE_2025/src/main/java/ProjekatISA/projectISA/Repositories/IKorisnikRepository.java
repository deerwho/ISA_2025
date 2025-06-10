package ProjekatISA.projectISA.Repositories;

import ProjekatISA.projectISA.Entities.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IKorisnikRepository extends JpaRepository<Korisnik, Integer> {
    Korisnik findByEmail(String email);

    /*@Query(nativeQuery = true,value = "SELECT * FROM korisnik WHERE email LIKE (%:ime%)")
    List<Korisnik> findAllByIme(@Param("ime") String ime);*/
}
