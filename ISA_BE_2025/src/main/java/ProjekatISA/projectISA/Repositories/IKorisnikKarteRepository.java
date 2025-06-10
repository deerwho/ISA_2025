package ProjekatISA.projectISA.Repositories;

import ProjekatISA.projectISA.Entities.Korisnik;
import ProjekatISA.projectISA.Entities.KorisnikKarte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKorisnikKarteRepository extends JpaRepository<KorisnikKarte, Integer> {
    //Korisnik findByEmail(String email);

    /*@Query(nativeQuery = true,value = "SELECT * FROM korisnik WHERE email LIKE (%:ime%)")
    List<Korisnik> findAllByIme(@Param("ime") String ime);*/
}