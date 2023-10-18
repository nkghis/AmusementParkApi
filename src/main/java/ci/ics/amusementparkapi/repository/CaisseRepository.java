package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {
}
