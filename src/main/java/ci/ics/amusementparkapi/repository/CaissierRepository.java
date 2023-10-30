package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Caisse;
import ci.ics.amusementparkapi.entity.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaissierRepository extends JpaRepository<Caissier, Long> {

    Optional<Caissier> findByMatricule(String matricule);
}
