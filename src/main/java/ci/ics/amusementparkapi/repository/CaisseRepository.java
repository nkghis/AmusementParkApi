package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {

    Optional<Caisse> findByMatricule(String matricule);
}
